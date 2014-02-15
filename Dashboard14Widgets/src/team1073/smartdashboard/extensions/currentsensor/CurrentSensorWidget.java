
package team1073.smartdashboard.extensions.currentsensor;

import edu.wpi.first.smartdashboard.gui.Widget;
import edu.wpi.first.smartdashboard.properties.MultiProperty;
import edu.wpi.first.smartdashboard.properties.Property;
import edu.wpi.first.smartdashboard.types.DataType;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.text.DecimalFormat;


public class CurrentSensorWidget extends Widget
{

    public static final DataType[] TYPES = {DataType.NUMBER };
    public static final String NAME = "Current Sensor";
    private double value = 0;
    public final MultiProperty currentSensor = new MultiProperty(this, "Current");

    public CurrentSensorWidget(){
        /*This constructor is only necessary for testing purposes*/
        currentSensor.add("0", 0.0);
        currentSensor.add("4", 4.1245);
        currentSensor.add("20", 20.755);
    }
    
    
    
    @Override
    public void setValue(Object o)
    {
        this.value = ((Number) o).doubleValue();
        DecimalFormat df = new DecimalFormat("#.##");
        value = Double.valueOf(df.format(value));
        repaint();
    }

    @Override
    public void init() 
    {
        setPreferredSize(new Dimension(200, 50));
    }

    @Override
    public void propertyChanged(Property prprt) 
    {
        setValue(prprt.getValue());
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        
        Dimension size = getSize();
        g.setColor(Color.black);
        g.fillRect(0, 0, size.width, size.height);
        
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Default", Font.BOLD, 32));
        if (value < 10)
            {
                g.drawString(value + " amps", (int) (size.width/8), (int) (size.height/1.5));
            }
        if (value >= 10)
            {
                g.drawString(value + " amps", (int) (size.width/12), (int) (size.height/1.5));
            }
    }
    
}
