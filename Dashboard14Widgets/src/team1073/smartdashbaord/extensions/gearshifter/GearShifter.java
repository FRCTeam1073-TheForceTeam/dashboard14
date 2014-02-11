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
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;

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
        Graphics2D g2 = (Graphics2D)g;
        Dimension size = getSize();
        //background
        Color c1 = new Color(0, 0, 0);
        Color c2 = new Color(49, 79, 79);
        
        GradientPaint gp = new GradientPaint(0, 0, c1, size.width/2, 0, c2);
        g2.setPaint(gp);
        g2.fill(new RoundRectangle2D.Double(0, 0, size.width-1, size.height-1, 10, 10));
        
        
        
        String gear = "";
        
        if (value == true)
        {
            gear = "Low Gear";
            g.setColor(Color.WHITE);
            g.setFont(new Font ("default", Font.BOLD, 30));
            g.drawString(gear, size.width/40-2, (int) (size.height/1.3));
        }
        else
        {
            gear = "High Gear";
            g.setColor(Color.WHITE);
            g.setFont(new Font ("default", Font.BOLD, 30));
            g.drawString(gear, size.width/40-2, (int) (size.height/1.3));
        }
        
        
    }
    
}