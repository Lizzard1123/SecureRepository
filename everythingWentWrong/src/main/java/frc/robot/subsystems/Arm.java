package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase{
    public final Spark armMotor = new Spark(5);

    public Arm(){
        super();
    }
    public void periodic(){
    }
    public void moveArm(double speed){
        armMotor.set(speed);
    }
}