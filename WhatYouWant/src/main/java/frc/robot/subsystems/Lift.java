package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lift extends SubsystemBase{
    public final TalonSRX liftMotor = new TalonSRX(6);

    public Lift(){
        super();
    }
    public void periodic(){
        
    }
    public void wiggleLift(double speed){
        liftMotor.set(ControlMode.PercentOutput, speed/100);
    }
}