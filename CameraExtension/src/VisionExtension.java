
import edu.wpi.first.smartdashboard.gui.StaticWidget;
import edu.wpi.first.smartdashboard.gui.Widget;
import edu.wpi.first.smartdashboard.properties.Property;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables2.client.NetworkTableClient;
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
    
    VisionThread worker;

    
    public VisionExtension()
    {

    }
    
    

    @Override
    public void init() {
        worker = new VisionThread();
        worker.addPropertyChangeListener(new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                
            }
        });
        worker.execute();
    }

    @Override
    public void propertyChanged(Property prprt) {
        
    }
    
    
}
