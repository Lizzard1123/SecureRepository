package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase{
    public final TalonSRX armMotor = new TalonSRX(5);

    public Arm(){
        super();
        //addChild("Arm Motor", armMotor);
    }
    public void periodic(){
           
    }
    public void moveArm(double speed){
        //other classes call on this funciton to move the armMotor at double speed
        armMotor.set(ControlMode.PercentOutput, speed/100);
    }
}