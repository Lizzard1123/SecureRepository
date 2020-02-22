package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lift extends SubsystemBase{
    public final Talon liftMotor = new Talon(6);

    public Lift(){
        super();
    }
    public void periodic(){
        
    }
    public void wiggleLift(double speed){
        liftMotor.set(speed);
    }
}