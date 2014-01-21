package team1073.smartdashboard.extensions.battery;

import edu.wpi.first.smartdashboard.gui.Widget;
import edu.wpi.first.smartdashboard.properties.Property;
import edu.wpi.first.smartdashboard.types.DataType;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class BatteryWidget extends Widget
{
    public static final DataType[] TYPES = {DataType.NUMBER };
    public static final String NAME = "Battery";
    private double value = 0.0;
    private String voltage = "";

    @Override
    public void setValue(Object o) 
    {
        this.value = ((Number) value).doubleValue();
        
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
        
        int fillage = (int) (size.height * value / 13);
        if (value < 10)
            g.setColor(Color.yellow);
        else if (value < 8)
            g.setColor(Color.red);
        else
            g.setColor(Color.green);
        g.fillRect(0, size.height - fillage, size.width, size.height);
        
        g.setColor(Color.black);
        g.drawRect(0, 0, size.width - 1, size.height - 1);
        
        voltage = value + "V";
        g.drawString(voltage, size.width/4, size.height/2);
        
        
        
    }
    
}
