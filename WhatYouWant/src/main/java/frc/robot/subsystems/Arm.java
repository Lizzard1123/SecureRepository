package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase{
    public final Talon armMotor = new Talon(5);

    public Arm(){
        super();
        addChild("Arm Motor", armMotor);
    }
    public void periodic(){
           
    }
    public void moveArm(double speed){
        armMotor.set(speed);
    }
}