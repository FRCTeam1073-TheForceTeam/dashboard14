
package team1073.smartdashboard.extensions.timecounter;


import edu.wpi.first.smartdashboard.gui.Widget;
import edu.wpi.first.smartdashboard.properties.Property;
import edu.wpi.first.smartdashboard.types.DataType;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class TimeCounterWidget extends Widget
{
    /*
    if robot == no connection
            {
                use 'my laptop' battery;
            } 
    Only use in comp. secret hack 
    */ 
    public static final DataType[] TYPES = {DataType.NUMBER };
    public static final String NAME = "TimeCounterWidget";
    private int value = 0;
    private int minutes;
    private int seconds;


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
        
        minutes = value / 60;
        seconds = value % 60;
        
        if (minutes == 2)
        {
            g.setColor(Color.red);
        }
        else
            g.setColor(Color.WHITE);
        
        g.drawString(minutes + ":" + seconds, size.width /6, size.height / 6);
        
        
    }
    
}
