package frc.robot.subsystems; 

import edu.wpi.first.wpilibj.Spark; 
import edu.wpi.first.wpilibj2.command.SubsystemBase; 
// import frc.robot.Constants; 
import edu.wpi.first.wpilibj.drive.DifferentialDrive; 
import edu.wpi.first.wpilibj.SpeedControllerGroup; 

public class DriveTrain extends SubsystemBase{
    public final Spark frontRightDrive = new Spark(0); 
    public final Spark frontLeftDrive = new Spark(1); 
    public final Spark backLeftDrive = new Spark(2); 
    public final Spark backRightDrive = new Spark(3); 

    public final SpeedControllerGroup left = new SpeedControllerGroup(frontLeftDrive, backLeftDrive); 
    public final SpeedControllerGroup right = new SpeedControllerGroup(frontRightDrive, backRightDrive); 

    public DifferentialDrive drive = new DifferentialDrive(left, right); 

    public DriveTrain(){
        super(); 
    }

    public void periodic(){
        drive.check();
        if(!(drive.isSafetyEnabled())){
            drive.setSafetyEnabled(true);
        } 
    }

    public void differentialDrive(double leftSpeed, double rightSpeed){
        if(leftSpeed<5 && leftSpeed>-5){leftSpeed = 0;}
        if(rightSpeed<5 && rightSpeed>-5){rightSpeed = 0;}
        
        left.set(leftSpeed*-1);
        backRightDrive.set(rightSpeed);

    }

    public void setSpeed(double speed){
        drive.setMaxOutput(speed); 
    }

}