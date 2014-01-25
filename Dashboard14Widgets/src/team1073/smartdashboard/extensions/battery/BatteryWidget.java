package team1073.smartdashboard.extensions.battery;

import edu.wpi.first.smartdashboard.gui.Widget;
import edu.wpi.first.smartdashboard.properties.MultiProperty;
import edu.wpi.first.smartdashboard.properties.Property;
import edu.wpi.first.smartdashboard.types.DataType;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class BatteryWidget extends Widget
{
    /*
    if robot == no connection
            {
                use 'my laptop' battery;
            } 
    Only use in comp. secret hack 
    */ 
    public static final DataType[] TYPES = {DataType.NUMBER };
    public static final String NAME = "Battery";
    private double value = 0.0;
    private String voltage = "";
    public final MultiProperty batteryStatus = new MultiProperty(this, "Battery Status");
    
    public BatteryWidget(){
        /*This constructor is only necessary for testing purposes*/
        batteryStatus.add("Low Battery", 5);
        batteryStatus.add("Battery Ready", 12);
        batteryStatus.add("Battery Lowish", 9);
        batteryStatus.setDefault("No Data");
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
        setPreferredSize(new Dimension(127, 50));
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
        
        int fillage = (int) (size.height * value / 13);
        if (value < 8)
            g.setColor(Color.red);
        else if (value < 10)
            g.setColor(Color.yellow);
        else
            g.setColor(Color.green);
        g.fillRect(0, size.height - fillage, size.width, size.height);
        
        g.setColor(Color.black);
        g.drawRect(0, 0, size.width - 1, size.height - 1);
        
        if(value == 0.0 || value < 8){
            g.setColor(Color.WHITE);
        }
        voltage = value + "V";
        g.drawString(voltage, size.width/4, size.height/2);
        
        
        
    }
    
}
