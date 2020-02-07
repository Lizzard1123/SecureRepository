package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lift extends SubsystemBase{
    public final Spark liftMotor = new Spark(6);

    public Lift(){
        super();
    }
    public void periodic(){
        
    }
    public void wiggleLift(double speed){
        liftMotor.set(speed);
    }
}