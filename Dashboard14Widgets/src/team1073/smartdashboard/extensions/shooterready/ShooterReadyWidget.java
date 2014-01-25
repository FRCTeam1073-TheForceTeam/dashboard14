/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team1073.smartdashboard.extensions.shooterready;

/**
 *
 * @author Patrick
 */
import edu.wpi.first.smartdashboard.gui.Widget;
import edu.wpi.first.smartdashboard.properties.Property;
import edu.wpi.first.smartdashboard.types.DataType;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JTextField;

public class ShooterReadyWidget extends Widget
{
    public static final DataType[] TYPES = {DataType.NUMBER };
    public static final String NAME = "Shooter Ready";
    private int value = -1;
    private JTextField jTextField1;
    
    

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
        jTextField1 = new javax.swing.JTextField();
        if (value == -2) //if value is -2 PSI is too low and distance is not safe to shoot
        {
            jTextField1.setText("PSI Low / Distance Wrong");
        }
        else if (value == -1) //if value is -1 PSI is too low but distance is okay
        {
            jTextField1.setText("PSI Low / Distance Okay");
        }
        else if (value == 0) //if value is 0 PSI is enough to shoot but distance is okay
        {
            jTextField1.setText("PSI Okay / Distance Wrong");
        }
        else if (value == 1) //if value is 1 PSI is okay and distance is also okay
        {
            jTextField1.setText("Shooter Ready!");
        }
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
        
        
        if (value == -2)
        {
            g.setColor(Color.RED);
        }
        else if (value == -1)
        {
            g.setColor(Color.YELLOW);
        }
        else if (value == 0)
        {
         g.setColor(Color.ORANGE);
        }
        else if (value == 1)
        {
            g.setColor(Color.GREEN);
        }
        
        
    }
    
}