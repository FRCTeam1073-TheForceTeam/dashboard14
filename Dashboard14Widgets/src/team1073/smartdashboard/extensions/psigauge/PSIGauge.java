/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team1073.smartdashboard.extensions.psigauge;

import edu.wpi.first.smartdashboard.gui.Widget;
//import edu.wpi.first.smartdashboard.properties.MultiProperty;
import edu.wpi.first.smartdashboard.properties.Property;
import edu.wpi.first.smartdashboard.types.DataType;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JTextField;

public class PSIGauge extends Widget 
{
    public static final DataType[] TYPES = {DataType.NUMBER };
    public static final String NAME = "PSI Gauge";
    private double value = 0;
        private JTextField jTextField2;

    
    @Override
    public void setValue(Object o) 
    {
        this.value = ((Number) o).doubleValue();
        
        repaint();

    }

    @Override
    public void init() 
    {
        setPreferredSize(new Dimension(60, 20));
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
                
        if (value == 60)
        {
            g.setColor(Color.GREEN);
            g.fillRect(0, 0, size.width, size.height);
            jTextField2.setText("Two Shots Ready");
        }
        else if (value <= 60 && value > 30)
        {
            g.setColor(Color.YELLOW);
            g.fillRect(0, 0, size.width, (int) (size.height - value/3.5));
            jTextField2.setText("One Shot Ready");
        }
        else if (value <= 30)
        {
              g.setColor(Color.RED);
              g.fillRect(0, 0, size.width, (int) (size.height - value*2.5));
              jTextField2.setText("Zero Shots Ready");
        }
       
    }
}
