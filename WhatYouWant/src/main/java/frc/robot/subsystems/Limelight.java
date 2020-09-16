/**
 * Theres alot here, and I'm not entirely sure because I don't remember!ύ.ὺ
 */
package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Limelight extends SubsystemBase{
    NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
    public static float steering_adjust = 0.0f;
    private final double height1 = 0;
    private final double height2 = 0;
    private final double angle1 = 0;
    private final double angle2 = 0;
    private double distance = 0;
    private double a1;
    private double a2;
    private float Kp = -0.1f;
    public double iniDistanceToObject(){
         //equation d = (h2-h1)/tan(a1+a2)
        a1 = angle1*180/Math.PI;
        a2 = angle2*180/Math.PI;
        distance = (height2-height1)/ Math.tan(a1 + a2);
        return distance;
    }
    public double distanceToObject(){
        return distance + distance;
    }


    public void limelightMode(boolean on){ //true == vision processing; false == ONLY camera
        NetworkTableInstance.getDefault().startClientTeam(3344);
        NetworkTableInstance.getDefault().startDSClient();
        NetworkTableEntry camMode = table.getEntry("camMode");
        NetworkTableEntry ledMode = table.getEntry("ledMode");
        if(on){
            camMode.setDouble(0);
            ledMode.setDouble(3);

        }   else{
            camMode.setDouble(1);
            ledMode.setDouble(1);
        }
        /**
         * camMode(0) = visionProcessing
         * camMode(1) = normal camera
         * ledMode(0) = LED mode set in current pipeline
         * ledMode(1) = force LED off
         * ledMode(2) = force blink
         * ledMode(3) = force on
         */
    }

    public void aim(DriveTrain drive){
        Kp = -0.1f; //originally -0.1f
        float min_command = 0.04f; //originally 0.05f

        double txd = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
        float tx = (float)txd;
        float heading_error = -tx;
        if (tx > 1.0)
        {
                steering_adjust = Kp*heading_error - min_command;
        }
        else if (tx < 1.0)
        {
                steering_adjust = Kp*heading_error + min_command;
        }
    }

    public void seek(DriveTrain drive){
        float tv = (float)NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
        float tx = (float)NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);

        if (tv == 0.0f)
        {
        // We don't see the target, seek for the target by spinning in place at a safe speed.
        steering_adjust = 0.3f;
        }
        else
        {
                // We do see the target, execute aiming code
                float heading_error = tx;
                steering_adjust = Kp * tx;
        }

    }
    public double getAimAdjust(){
        return (double)steering_adjust;
    }
    public double getSeekAdjust(){
        return (double)steering_adjust;
    }
}