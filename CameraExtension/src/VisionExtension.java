
import edu.wpi.first.smartdashboard.gui.StaticWidget;
import edu.wpi.first.smartdashboard.properties.Property;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Greg
 */
public class VisionExtension extends StaticWidget{
    
    public static final String NAME = "VisionExtension";
    VisionThread worker;
    NetworkTable table;
    boolean HOT = false;
    boolean connected = false;

    
    public VisionExtension()
    {

    }
    
    

    @Override
    public void init() {
            table = NetworkTable.getTable("visionTable");
            System.out.printf("Connected: %s, Server: %s\n", table.isConnected() ? "true" : "false", table.isServer() ? "true" : "false");
            setPreferredSize(new Dimension(100, 100));
            worker = new VisionThread();
            worker.addPropertyChangeListener(new PropertyChangeListener() {

                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if ("HOT".equals(evt.getPropertyName())) {
                        HOT = (boolean) evt.getNewValue();
                        table.putBoolean("Hot", HOT);
                        repaint();
                    }
                    else if (evt.getPropertyName().equals("connected"))
                    {
                        connected = (boolean) evt.getNewValue();
                        repaint();
                    }
                }
            });
            worker.execute();
    }

    @Override
    public void propertyChanged(Property prprt) {
        
    }
 
    @Override
    protected void paintComponent(Graphics g)
    {
        Dimension size = getSize();
        if (!connected)
            g.setColor(Color.red);
        else
            g.setColor(Color.green);
        g.fillRect(0, 0, size.width, size.height);
        g.setColor(Color.BLACK);
        g.drawString("HOT:" + HOT, size.width/2, size.height/2);
    }
    
}
