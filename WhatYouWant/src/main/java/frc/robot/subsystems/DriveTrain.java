package frc.robot.subsystems; 

import com.ctre.phoenix.motorcontrol.can.*;
import com.ctre.phoenix.motorcontrol.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveTrain extends SubsystemBase{
    public final VictorSPX frontRightDrive = new VictorSPX(1); 
    public final VictorSPX frontLeftDrive = new VictorSPX(2); 
    public final VictorSPX backLeftDrive = new VictorSPX(3); 
    public final VictorSPX backRightDrive = new VictorSPX(4); 

    //public final SpeedControllerGroup left = new SpeedControllerGroup(frontLeftDrive, backLeftDrive); 
    //public final SpeedControllerGroup right = new SpeedControllerGroup(frontRightDrive, backRightDrive); 
    //public final GroupMotorControllers left = new GroupMotorControllers(frontLeftDrive, backLeftDrive);

    //public DifferentialDrive drive = new DifferentialDrive(left, right); 

    public DriveTrain(){
        super(); 
    }

    public void periodic(){
        
        /*drive.check();
        if(!(drive.isSafetyEnabled())){
            drive.setSafetyEnabled(true);
        }
        /
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
            frontRightDrive.set(ControlMode.PercentOutput, rightSpeed);
            frontLeftDrive.set(ControlMode.PercentOutput, leftSpeed*-1);
            backLeftDrive.set(ControlMode.PercentOutput, leftSpeed*-1);
            backRightDrive.set(ControlMode.PercentOutput, rightSpeed);

    }

    public void setSpeed(double speed){
        //frontRightDrive.max
        frontRightDrive.configPeakOutputForward(speed/100);
        frontLeftDrive.configPeakOutputForward(speed/100);
        backLeftDrive.configPeakOutputForward(speed/100);
        backRightDrive.configPeakOutputForward(speed/100);
    }

}