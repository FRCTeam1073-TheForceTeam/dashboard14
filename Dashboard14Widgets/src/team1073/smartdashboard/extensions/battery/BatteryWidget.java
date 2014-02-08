package team1073.smartdashboard.extensions.battery;

import edu.wpi.first.smartdashboard.gui.StaticWidget;
import edu.wpi.first.smartdashboard.properties.MultiProperty;
import edu.wpi.first.smartdashboard.properties.Property;
import edu.wpi.first.smartdashboard.types.DataType;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
<<<<<<< HEAD
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import java.text.DecimalFormat;


=======
import java.text.DecimalFormat;

>>>>>>> 1062a19c94400ad5a2ee9189cbbdfb0a430897ae
public class BatteryWidget extends StaticWidget
{
    public static final DataType[] TYPES = {DataType.NUMBER };
    public static final String NAME = "Battery";
    private double value = 0.0;
    private String voltage = "";
    public final MultiProperty batteryStatus = new MultiProperty(this, "Battery Status");
    
    public BatteryWidget(){
        /*This constructor is only necessary for testing purposes*/
<<<<<<< HEAD
        batteryStatus.add("Battery Low", 5);
        batteryStatus.add("Battery Ready", 12);
=======
>>>>>>> 1062a19c94400ad5a2ee9189cbbdfb0a430897ae
        batteryStatus.add("Low Battery", 5);
        batteryStatus.add("Battery Ready", 11.51498031616211);
        batteryStatus.add("Battery Relatively Low", 9);
        batteryStatus.setDefault("No Data");
    }

    //@Override
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
        setPreferredSize(new Dimension(90, 200));
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
        g.setColor(Color.black);
        g2.fill(new RoundRectangle2D.Double(0,0, size.width, size.height, 10, 10));
        Color c1;
        Color c2;
        
        int fillage = (int) (size.height * value / 13);
        if (value < 8)
        {
            c2 = new Color(255, 0, 0);
            c1 = new Color(205, 0, 0);
        }
            
        else if (value < 10)
        {
            c2 = new Color(255, 140, 0);
            c1 = new Color(238, 118, 0);
        }
        else
        {
            c2 = new Color(0, 255, 0);
            c1 = new Color(0, 195, 0);
        }
        GradientPaint gp = new GradientPaint(0, 0, c1, size.width/2, 0, c2, true);
        g2.setPaint(gp);
        g2.fill(new RoundRectangle2D.Double(1, size.height - fillage, size.width-2, fillage-1, 10, 10));
        
        g.setColor(Color.white);

        voltage = value + "V";
        
        g.setFont(new Font ("default", Font.BOLD, 32));
        
        if (value < 9.99)
        {
            g.drawString(voltage, size.width/6, (int) (size.height/2));
        }
        else
        {
            g.drawString(voltage, (size.width/6)-12, (int) (size.height/2));
        }
        

    }
    
}
