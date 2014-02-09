/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team1073.smartdashboard.extensions.psigauge;

import edu.wpi.first.smartdashboard.gui.StaticWidget;
import edu.wpi.first.smartdashboard.properties.MultiProperty;
import edu.wpi.first.smartdashboard.properties.Property;
import edu.wpi.first.smartdashboard.types.DataType;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Line2D;
import java.awt.RadialGradientPaint;
import java.awt.geom.Point2D;
import java.text.DecimalFormat;

public class PSIGauge extends StaticWidget 
{
    public static final DataType[] TYPES = {DataType.NUMBER };
    public static final String NAME = "PSI Gauge";
    private double value = 0.0;
    public final MultiProperty PSI = new MultiProperty(this, "PSI");
    
    
    
    

    public PSIGauge(){
        /*This constructor is only necessary for testing purposes*/
        PSI.add("2 Shots", 104.69983673095703);
        PSI.add("1 Shot", 45.0);
        PSI.add("No Shots", 0.0);

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
        setPreferredSize(new Dimension(400, 200));
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
        String pressure = "" + value;
        Color c1;
        Color c2;

        
        Point2D center = new Point2D.Float(size.width/2, size.height);
        float radius = size.height-(size.height/16);
        float[] dist = {0.0f, 1.0f};
        Color[] colors = {Color.BLACK, Color.RED};
        RadialGradientPaint rgp = new RadialGradientPaint(center, radius, dist, colors);
        g2.setPaint(rgp);
        
        g2.fill(new Arc2D.Double(0, 0, size.width-1, (size.height*2)-2, 0, 180, Arc2D.CHORD));
        g2.setPaint(Color.black);
        g2.draw(new Arc2D.Double(0, 0, size.width-1, (size.height*2)-2, 0, 180, Arc2D.CHORD));
        double radii = size.width/2;
        double degree = (value *3)/2;
        double centerX = size.width/2;
        double centerY = size.height;

        double Endx = centerX - (double)((Math.cos(Math.toRadians(degree)))*(radii-(size.width/16)));
        double Endy = centerY - (double)((Math.sin(Math.toRadians(degree)))*(radii-(size.width/16)));
        
        final double Start30X = radii - (Math.cos(Math.toRadians(30)))*radii;
        final double Start30Y = size.height - (Math.sin(Math.toRadians(30)))*radii;
        final double End30X = radii - (Math.cos(Math.toRadians(30)))*(radii-10);
        final double End30Y = (size.height) - (Math.sin(Math.toRadians(30)))*(radii-10);
        
        final double Start60X = radii -(Math.cos(Math.toRadians(60)))*radii;
        final double Start60Y = size.height - (Math.sin(Math.toRadians(60)))*radii;
        final double End60X = radii - (Math.cos(Math.toRadians(60)))*(radii-10);
        final double End60Y = (size.height) - (Math.sin(Math.toRadians(60)))*(radii-10);
        
        final double Start120X = radii - (Math.cos(Math.toRadians(120)))*radii;
        final double Start120Y = size.height - (Math.sin(Math.toRadians(120)))*radii;
        final double End120X = radii - (Math.cos(Math.toRadians(120)))*(radii-10);
        final double End120Y = (size.height) - (Math.sin(Math.toRadians(120)))*(radii-10);
        
        final double Start150X = radii - (Math.cos(Math.toRadians(150)))*radii;
        final double Start150Y = size.height - (Math.sin(Math.toRadians(150)))*radii;
        final double End150X = radii - (Math.cos(Math.toRadians(150)))*(radii-10);
        final double End150Y = (size.height) - (Math.sin(Math.toRadians(150)))*(radii-10);
        
        g2.setPaint(Color.DARK_GRAY);
        g2.draw(new Line2D.Double(size.width/2, 1, size.width/2, 20));
        g2.draw(new Line2D.Double(Start30X, Start30Y, End30X, End30Y));
        g2.draw(new Line2D.Double(Start60X, Start60Y, End60X, End60Y));
        g2.draw(new Line2D.Double(Start120X, Start120Y, End120X, End120Y));
        g2.draw(new Line2D.Double(Start150X, Start150Y, End150X, End150Y));
        
        g2.setPaint(Color.WHITE);
        String PSI = value + "PSI";
        g.setFont(new Font ("default", Font.BOLD, 32));
        g.drawString(PSI, (int) (size.width/2.7), size.height/2);
        
        g2.setPaint(Color.DARK_GRAY);
        g2.draw(new Line2D.Double(size.width/2, size.height, Endx, Endy));
        
        
        
                
        /*if (value < 120.0 && value >= 80)
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
        }*/   
    }
}
