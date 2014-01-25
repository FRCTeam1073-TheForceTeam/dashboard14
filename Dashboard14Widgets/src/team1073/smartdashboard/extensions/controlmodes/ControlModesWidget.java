/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team1073.smartdashboard.extensions.controlmodes;


import edu.wpi.first.smartdashboard.gui.StaticWidget;
import edu.wpi.first.smartdashboard.gui.Widget;
import edu.wpi.first.smartdashboard.properties.MultiProperty;
import edu.wpi.first.smartdashboard.properties.Property;
import edu.wpi.first.smartdashboard.types.DataType;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class ControlModesWidget extends StaticWidget
{
    public static final DataType[] TYPES = {DataType.NUMBER };
    public static final String NAME = "Control Mode";
    private int value = -1;
    public final MultiProperty controlModes = new MultiProperty(this, "Control Mode");

    //@Override
    public ControlModesWidget(){
        controlModes.add("Off", -1);
        controlModes.add("Autonomous", 0);
        controlModes.add("TeleOp", 1);
    }
    public void setValue(Object o) 
    {
        this.value = ((Number) o).intValue();
       
        repaint();

    }

    @Override
    public void init() 
    {
        setPreferredSize(new Dimension(127, 50));
    }

    @Override
    public void propertyChanged(Property prprt) 
    {
        setValue(prprt.getValue());
        //repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        Dimension size = getSize();
        //background
        g.setColor(Color.black);
        g.fillRect(0, 0, size.width, size.height);
        
        String mode = "";
        
        if (value == -1)
        {
            mode = "Off";
            g.setColor(Color.RED);
            g.fillRect(0, 0, size.width, size.height);
            g.setColor(Color.black);
            g.drawString(mode, size.width/5, size.height/5);
        }
        else if (value == 0)
        {
            mode = "Autonomous";
            g.setColor(Color.orange);
            g.fillRect(0, 0, size.width, size.height);
            g.setColor(Color.black);
            g.drawString(mode, size.width/5, size.height/5);
        }
        else
        {
         mode = "Teleoperated";
         g.setColor(Color.GREEN);
         g.fillRect(0, 0, size.width, size.height);
         g.setColor(Color.black);
         g.drawString(mode, size.width/5, size.height/5);
        }
        
        
    }
    
}
