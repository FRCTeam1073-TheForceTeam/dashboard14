package team1073.smartdashboard.extensions.distance;

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
import java.awt.geom.Rectangle2D;

public class Distance extends Widget
{
    public static final DataType[] TYPES = {DataType.NUMBER };
    public static final String NAME = "Distance";
    private double value;
    public final MultiProperty distance = new MultiProperty(this, "distance");
    private int feet;
    private int inches;
    private int inches2;
    private String strFeet = "";
    private String strInches = "";


    
    
    public Distance()
    {
        distance.add("7.5 ft", 229);
        distance.add("6.5 ft", 200);
        distance.add("12 ft", 366);
        distance.add("12ft 11in", 394);
        
    }

    @Override
    public void setValue(Object o) 
    {
        this.value = ((Number) o).doubleValue();
        inches = (int) (value/2.54);
        feet = inches / 12;
        inches2 = inches % 12;
        strFeet = "" + feet;
        strInches = "" + inches2;
        repaint();
    }

    @Override
    public void init() 
    {
        setPreferredSize(new Dimension(225, 57));

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
        
        Color c1 = new Color(255,140,0);
        Color c2 = new Color(255,165,0);
        GradientPaint gp = new GradientPaint(0, 0, c1, size.width/2, 0, c2);
        
        g2.setPaint(gp);
        g2.fill(new Rectangle2D.Double(0, 0, size.width, size.height));
        
        
        g2.setPaint(Color.BLACK);
        g2.setFont(new Font("Default", Font.BOLD, 72));
        g2.drawString(strFeet, 1, size.height-1);
        g2.drawString(strInches, (size.width/2), size.height-1);
        g2.setFont(new Font("Default", Font.BOLD, 12));
        g2.drawString("ft", 100, size.height-1);
        g2.drawString("in", size.width-25, size.height-1);
        
        
    }
}