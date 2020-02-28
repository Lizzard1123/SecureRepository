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
    public void yellowBoi(double speed){
        intakeMotor.set(ControlMode.PercentOutput, speed/100);
    }
}