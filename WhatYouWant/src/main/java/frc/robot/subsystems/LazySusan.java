package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LazySusan extends SubsystemBase{
    public final VictorSPX lazySusanMotor = new VictorSPX(8);

    public LazySusan(){
        super();
    }
    public void periodic(){
        
    }
    public void spinSusan(double speed){
        lazySusanMotor.set(ControlMode.PercentOutput, speed/100);
    }
}