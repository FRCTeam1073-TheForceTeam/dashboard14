package team1073.smartdashboard.extensions.collectorAngle;

import edu.wpi.first.smartdashboard.gui.Widget;
import edu.wpi.first.smartdashboard.properties.MultiProperty;
import edu.wpi.first.smartdashboard.properties.Property;
import edu.wpi.first.smartdashboard.types.DataType;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class CollecterAngle extends Widget
{
    public static final DataType[] TYPES = {DataType.STRING };
    public static final String NAME = "Collecter Angle";
    private String value = "";
    public final MultiProperty collecterAngle = new MultiProperty(this, "Collecter Angle");
    private String ELEVATOR_ACT = "";
    private String ELEVATOR_UP = "";
    private String ELEVATOR_DOWN = "";
    private String[] ar = new String[3];
    private double max;
    private double min;
    private double act; 

    
    
    public CollecterAngle()
    {
        collecterAngle.add("1", "3.455512345,4.023445,1.988696896986");
        collecterAngle.add("2", "0.987,6.7978,1.244587");
        collecterAngle.add("3", "1.63,2.456,5.4655");
    }

    @Override
    public void setValue(Object o) 
    {
        this.value = (String) o;
        ar = value.split(",");
        ELEVATOR_ACT = ar[0];
        ELEVATOR_UP = ar[1];
        ELEVATOR_DOWN = ar[2];
        act = Double.parseDouble(ELEVATOR_ACT);
        max = Double.parseDouble(ELEVATOR_UP);
        min = Double.parseDouble(ELEVATOR_DOWN);
        
        repaint();

    }

    @Override
    public void init() 
    {
        setPreferredSize(new Dimension(64, 100));

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
        
        g2.setFont(new Font("Default", Font.BOLD, 32));
        
        g2.setPaint(Color.ORANGE);
        g2.fill(new Rectangle2D.Double(0, 0, size.width, size.height/3));
        
        g2.setPaint(Color.BLACK);
        g2.drawString(ELEVATOR_UP, 0, size.height/3);
        
        if (act < max && act > min)
        {
            g2.setPaint(Color.WHITE);
        }
        else
        {
            g2.setPaint(Color.RED);
        }
        g2.fill(new Rectangle2D.Double(0, size.height/3, size.width, size.height/3));
        
        g2.setPaint(Color.BLACK);
        g2.drawString(ELEVATOR_ACT, 0, (size.height/3)+ (size.height/3));
        
        g2.setPaint(Color.CYAN);
        g2.fill(new Rectangle2D.Double(0 ,(size.height/3) + (size.height/3), size.width, size.height/3));
        
        g2.setPaint(Color.BLACK);
        g2.drawString(ELEVATOR_DOWN, 0, size.height);
        
    }
    
}