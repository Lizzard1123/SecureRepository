/**
 * Yes, I named the Lazy Susan motor "Sheryl."
 * What're you gonna do, change it?
 * Do it, coward.
 * Class instantiates lazy susan motor and sets up spinSusan() method to spin le susan
 */
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LazySusan extends SubsystemBase{
    public final VictorSPX sheryl = new VictorSPX(8);

    public LazySusan(){
        super();
    }
    public void periodic(){
        
    }
    public void spinSusan(double speed){
        sheryl.set(ControlMode.PercentOutput, speed/100);
    }
}