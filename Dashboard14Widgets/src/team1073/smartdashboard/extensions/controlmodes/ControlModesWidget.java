/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team1073.smartdashboard.extensions.controlmodes;


import edu.wpi.first.smartdashboard.gui.Widget;
import edu.wpi.first.smartdashboard.properties.Property;
import edu.wpi.first.smartdashboard.types.DataType;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class ControlModesWidget extends Widget
{
    public static final DataType[] TYPES = {DataType.NUMBER };
    public static final String NAME = "Control Mode";
    private int value = -1;

    @Override
    public void setValue(Object o) 
    {
        this.value = ((Number) value).intValue();
        
        repaint();

    }

    @Override
    public void init() 
    {
        setPreferredSize(new Dimension(50, 127));
    }

    @Override
    public void propertyChanged(Property prprt) 
    {
   
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
            g.drawString(mode, size.width/5, size.height/5);
        }
        else if (value == 0)
        {
            mode = "Autonomous";
            g.setColor(Color.orange);
            g.drawString(mode, size.width/5, size.height/5);
        }
        else
        {
         mode = "Teleoperated";
         g.setColor(Color.GREEN);
         g.drawString(mode, size.width/5, size.height/5);
        }
        
        
    }
    
}
