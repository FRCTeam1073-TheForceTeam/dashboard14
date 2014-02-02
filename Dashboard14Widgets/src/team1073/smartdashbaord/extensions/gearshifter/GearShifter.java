/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team1073.smartdashbaord.extensions.gearshifter;


import edu.wpi.first.smartdashboard.gui.Widget;
import edu.wpi.first.smartdashboard.properties.MultiProperty;
import edu.wpi.first.smartdashboard.properties.Property;
import edu.wpi.first.smartdashboard.types.DataType;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

public class GearShifter extends Widget
{
    public static final DataType[] TYPES = {DataType.BOOLEAN };
    public static final String NAME = "Gear Shifter";
    private boolean value = true;
    public final MultiProperty gearStatus = new MultiProperty(this, "Gear Status");

    
    public GearShifter(){
        /*This constructor is only necessary for testing purposes*/
        gearStatus.add("Gear One", true);
        gearStatus.add("Gear Two", false);
    }
    @Override
    public void setValue(Object o) 
    {
        this.value = ((Boolean) o).booleanValue();
       
        repaint();

    }

    @Override
    public void init() 
    {
        setPreferredSize(new Dimension(150, 50));
    }

    @Override
    public void propertyChanged(Property prprt) 
    {
        setValue(prprt.getValue());
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        Dimension size = getSize();
        //background
        g.setColor(Color.black);
        g.fillRect(0, 0, size.width, size.height);
        
        String gear = "";
        
        if (value == true)
        {
            gear = "Gear One";
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, size.width, size.height);
            g.setColor(Color.GREEN);
            g.setFont(new Font ("default", Font.BOLD, 32));
            g.drawString(gear, size.width/40, (int) (size.height/1.3));
        }
        else
        {
            gear = "Gear Two";
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, size.width, size.height);
            g.setColor(Color.GREEN);
            g.setFont(new Font ("default", Font.BOLD, 32));
            g.drawString(gear, size.width/40, (int) (size.height/1.3));
        }
        
    }
    
}