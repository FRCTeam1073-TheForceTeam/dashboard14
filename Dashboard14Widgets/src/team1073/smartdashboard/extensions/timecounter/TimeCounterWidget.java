
package team1073.smartdashboard.extensions.timecounter;


import edu.wpi.first.smartdashboard.gui.StaticWidget;
import edu.wpi.first.smartdashboard.properties.MultiProperty;
import edu.wpi.first.smartdashboard.properties.Property;
import edu.wpi.first.smartdashboard.types.DataType;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

public class TimeCounterWidget extends StaticWidget
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
    public final MultiProperty timeCount = new MultiProperty(this, "Time");

    public TimeCounterWidget(){
        /*This constructor is only necessary for testing purposes*/
        timeCount.add("Match Not Started", 150);
        timeCount.add("120", 120);
        timeCount.add("60", 80);
        timeCount.add("45", 45);

    }
    
    
    //@Override
    public void setValue(Object o) 
    {
        this.value = ((Number) o).intValue();
        
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
        
        minutes = value / 60;
        seconds = value % 60;
        
        if (minutes == 2 && seconds == 30)
        {
            g.setColor(Color.WHITE);
        }
        else{
            g.setColor(Color.GREEN);
        }
        g.fillRect(0, 0, size.width, size.height);
        g.setColor(Color.BLACK);
        if (seconds == 0)
        {
            g.setFont(new Font ("Default", Font.BOLD, 32));
            g.drawString(minutes + ":" + seconds + 0, size.width/4, (int) (size.height/1.5));
        }
        if (seconds != 0)
        {
            g.setFont(new Font ("Default", Font.BOLD, 32));
            g.drawString(minutes + ":" + seconds, size.width/4, (int) (size.height/1.5));
        }
    }
    
}
