package frc.robot.subsystems; 

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase; 
// import frc.robot.Constants; 
import edu.wpi.first.wpilibj.drive.DifferentialDrive; 
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.RobotContainer;
import frc.robot.commands.DriveTele;
public class DriveTrain extends SubsystemBase{
    public final VictorSP frontRightDrive = new VictorSP(1); 
    public final VictorSP frontLeftDrive = new VictorSP(2); 
    public final VictorSP backLeftDrive = new VictorSP(3); 
    public final VictorSP backRightDrive = new VictorSP(4); 

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
        /**
         * System.out.println(RobotContainer.stickMain.getLeftJoyY());
         * System.out.println(RobotContainer.stickMain.getRightJoyY()); 
         */
        
    }
    public void initDefaultCommand(){
        //setDefaultCommand(new DriveTele(RobotContainer.differential, RobotContainer.stickMain));
    }

    public void differentialDrive(double leftSpeed, double rightSpeed){
        /**
         * if(leftSpeed<5 && leftSpeed>-5){leftSpeed = 0;}
        if(rightSpeed<5 && rightSpeed>-5){rightSpeed = 0;}
         */
            drive.tankDrive(leftSpeed, rightSpeed);

    }

    public void setSpeed(double speed){
        drive.setMaxOutput(speed); 
    }

}