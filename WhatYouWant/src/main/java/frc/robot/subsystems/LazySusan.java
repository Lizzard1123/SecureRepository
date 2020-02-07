package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LazySusan extends SubsystemBase{
    public final Spark lazySusanMotor = new Spark(4);

    public LazySusan(){
        super();
    }
    public void periodic(){
        
    }
    public void spinSusan(double speed){
        lazySusanMotor.set(speed);
    }
}