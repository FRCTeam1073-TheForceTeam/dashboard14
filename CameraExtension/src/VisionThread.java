
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import javax.swing.SwingWorker;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Greg 
 */
public class VisionThread extends SwingWorker<Boolean, String>{

    RR_API roboRealm;
    private boolean HOT;
    private boolean HOT_OLD;
    private boolean old_connected;
    int counter;
    public VisionThread()
    {
        //visionTable = NetworkTable.getTable("visionTable");
        roboRealm = new RR_API();
        roboRealm.connect("localhost");
        counter = 0;
    }
    
    @Override
    protected Boolean doInBackground() throws Exception {
    
        while (!isDone() && !isCancelled()) {
            if (!roboRealm.connected)
            {
                firePropertyChange("connected", old_connected, false);
                old_connected = false;
                roboRealm.connect("localhost");
            }
            else{
                firePropertyChange("connected", old_connected, true);
                old_connected = true;
            }

            getRRVars();
            counter++;
            //visionTable.putBoolean("HOT" +counter, HOT);
            firePropertyChange("HOT", HOT_OLD, HOT);
            HOT_OLD = HOT;
        }
        return true;
    }

    private void getRRVars()
    {
        try {
            String blobCount = (roboRealm.getVariable("BLOB_COUNT"));
//            if (blobCount.equals("1") )//needs work
//            {
//                HOT = true;
//            }
//            else if (blobCount.equals(null))
//                HOT = false;//not.
            HOT = (Integer.parseInt(blobCount))>0;
            
        }
        catch (Exception e)
        {
            HOT = false;
            System.out.println(e);
            e.printStackTrace();
        }
    }
    
}
