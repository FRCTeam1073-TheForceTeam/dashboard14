/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team1073.smartdashboard.extensions.psigauge;

import edu.wpi.first.smartdashboard.gui.Widget;
import edu.wpi.first.smartdashboard.properties.MultiProperty;
import edu.wpi.first.smartdashboard.properties.Property;
import edu.wpi.first.smartdashboard.types.DataType;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

public class PSIGauge extends Widget 
{
    public static final DataType[] TYPES = {DataType.NUMBER };
    public static final String NAME = "PSI Gauge";
    private double value = 0.0;
    public final MultiProperty PSI = new MultiProperty(this, "PSI");

    public PSIGauge(){
        /*This constructor is only necessary for testing purposes*/
        PSI.add("2 Shots", 115.0);
        PSI.add("1 Shot", 45.0);
        PSI.add("No Shots", 20.0);

    }
    
    @Override
    public void setValue(Object o) 
    {
        this.value = ((Number) o).doubleValue();
        
        repaint();

    }

    @Override
    public void init() 
    {
        setPreferredSize(new Dimension(200, 150));
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
        String pressure = "" + value;
        g.setColor(Color.black);
        g.fillRect(0, 0, size.width, size.height);
                
        if (value < 120.0 && value >= 80)
        {
            g.setColor(Color.GREEN);
            g.fillRect(0, size.height - (int) (value), size.width,size.height);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Default", Font.BOLD, 22));
            g.drawString("Two Shots Ready", size.width /17, (int) (size.height/6));
            g.setFont(new Font("Default", Font.BOLD, 22));
            g.drawString(pressure, (int) (size.width/2.7), (int) (size.height/2.8));
        }
        else if (value < 80.0 && value > 30.0)
        {
            g.setColor(Color.YELLOW);
            g.fillRect(0, size.height - (int) (value), size.width,size.height);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Default", Font.BOLD, 22));
            g.drawString("One Shot Ready", size.width /10, (int) (size.height/6));
            g.setColor(Color.WHITE);
            g.setFont(new Font("Default", Font.BOLD, 22));
            g.drawString(pressure, (int) (size.width/2.5), size.height/3);
        }
        else if (value <= 30.0)
        {
              g.setColor(Color.RED);
              g.fillRect(0, size.height - (int) (value), size.width,size.height);
              g.setColor(Color.WHITE);
              g.setFont(new Font("Default", Font.BOLD, 22));
              g.drawString("Not Ready", size.width/4, (int) (size.height/6));
              g.setColor(Color.WHITE);
              g.setFont(new Font("Default", Font.BOLD, 22));
              g.drawString(pressure, (int) (size.width/2.5), size.height/3);
        }   
    }
}
