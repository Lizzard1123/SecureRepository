    package frc.robot.subsystems;

import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import java.lang.Math;
//import frc.robot.lib.motion.Util;
//import frc.robot.lib.obj.VisionTarget;
//import frc.robot.lib.obj.factories.VisionTargetFactory;

public class Limelight extends SubsystemBase{
    private final double height1 = 0;
    private final double height2 = 0;
    private final double angle1 = 0;
    private final double angle2 = 0;
    private double distance = 0;
    private double a1;
    private double a2;
   
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
    
}