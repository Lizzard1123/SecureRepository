package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase{
    public final Spark intakeMotor = new Spark(7);

    public Intake(){
        super();
    }
    public void periodic(){
        
    }
    public void yellowBoi(double speed){
        intakeMotor.set(speed);
    }
}