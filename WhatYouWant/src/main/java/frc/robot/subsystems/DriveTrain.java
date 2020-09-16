/**
 * Instantiates the DriveTrain object and all the methods that can be accessed from it.
 */
package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;
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
    //sets motor speed to either double leftSpeed or double rightSpeed
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
        //forward???
        if(RobotContainer.stickMain.getRightJoyY()<0){
            frontRightDrive.configPeakOutputReverse(speed*-1/100);
            backRightDrive.configPeakOutputReverse(speed*-1/100);  
        }
        if(RobotContainer.stickMain.getLeftJoyY()<0){
            frontLeftDrive.configPeakOutputForward(speed/100);
            backLeftDrive.configPeakOutputForward(speed/100);
        }
        //backward???
        if(RobotContainer.stickMain.getRightJoyY()>0){
            frontRightDrive.configPeakOutputForward(speed/100);
            backRightDrive.configPeakOutputForward(speed/100);
        }
         if(RobotContainer.stickMain.getLeftJoyY()>0){
            frontLeftDrive.configPeakOutputReverse(speed*-1*.975/100);
            backLeftDrive.configPeakOutputReverse(speed*-1*.975/100);
        }
        //phoenix motors operate from -1.0 to 1.0 and speed is from -100 to 100, so division must be made
        //totally found that out before an injury, ha 
        

    }

}