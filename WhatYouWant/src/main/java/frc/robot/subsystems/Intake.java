/**
 * wow this is teeny compared to DriveTrain, oof
 */
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{
    public final VictorSPX intakeMotor = new VictorSPX(7);

    public Intake(){
        super();
    }
    public void periodic(){
        
    }
    //when .yellowBoi() is called upon, moves intake motor at speed parameters
    public void yellowBoi(double speed){
        intakeMotor.set(ControlMode.PercentOutput, speed/100);
        //phoenix motors operate from -1.0 to 1.0 and speed is from -100 to 100, so division must be made
    }
}