
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
            //wait(100);

            getRRVars();
            counter++;
            //visionTable.putBoolean("HOT" +counter, HOT);
            firePropertyChange("HOT", HOT_OLD, HOT);
            HOT_OLD = HOT;
            /*publish("Complete");
            setProgress(100);*/
        }
        return true;
    }
    
    private void getRRVars()
    {
        try {
            int blobCount = Integer.parseInt(roboRealm.getVariable("BLOB_COUNT"));
            if (blobCount > 2)//needs work
            {
                HOT = true;
            }
            else
                HOT = false;//not
        }
        catch (Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
    }
    
}
