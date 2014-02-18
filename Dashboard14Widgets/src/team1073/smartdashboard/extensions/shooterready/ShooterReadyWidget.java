package team1073.smartdashboard.extensions.shooterready;

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

public class ShooterReadyWidget extends Widget
{
    public static final DataType[] TYPES = {DataType.NUMBER };
    public static final String NAME = "Shooter Ready";
    private int value = -1;
    public final MultiProperty shooterReady = new MultiProperty(this, "Pneumatics Status");
    
    public ShooterReadyWidget(){
        /*This constructor is only necessary for testing purposes*/
        shooterReady.add("Low PSI, No Distance", -2);
        shooterReady.add("All Systems Nominal", 1);
    }

    @Override
    public void setValue(Object o) 
    {
        this.value = ((Number) o).intValue();
        
        repaint();

    }

    @Override
    public void init() 
    {
        setPreferredSize(new Dimension(360, 50));

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
        //g.fillRect(0, 0, size.width, size.height);
        Color c1;
        Color c2;
        
        
        if (value == -2 || value == 0)
        {
            //g.setColor(Color.RED);
            c2 = new Color(255, 0, 0);
            c1 = new Color(205, 0, 0);
        }

        else
        {
            //g.setColor(Color.GREEN);
            c2 = new Color(0, 255, 0);
            c1 = new Color(0, 195, 0);
        }
        
        GradientPaint gp = new GradientPaint(0, 0, c1, size.width/2, 0, c2);
        
        //g.fillRect(0, 0, size.width, size.height);
        g2.setPaint(Color.BLACK);
        g2.fill(new Rectangle2D.Double(0, 0, size.width, size.height));
        g2.setPaint(gp);
        g2.fill(new Rectangle2D.Double(1,1, size.width-2, size.height-2));
        
        //Moved this here to allow for more streamlined GUI
        //jTextField1 = new javax.swing.JTextField();
        g.setColor(Color.BLACK);
        if (value == -2 || value == 0) //if value is -2 PSI is too low and distance is not safe to shoot
        {
            g.setFont(new Font ("default", Font.BOLD, 26));
            g.drawString("Distance Wrong", size.width/19, (int) (size.height/1.5));
        }
        else
        {
            g.setFont(new Font ("default", Font.BOLD, 26));
            g.drawString("Distance Okay", size.width/19, (int) (size.height/1.5));
        }
    }
    
}