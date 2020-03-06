package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotContainer;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.*;


public class DriveTrain extends SubsystemBase{
    private final VictorSPX frontRightDrive = new VictorSPX(1);
    private final VictorSPX frontLeftDrive = new VictorSPX(2);
    private final VictorSPX backLeftDrive = new VictorSPX(3);
    private final VictorSPX backRightDrive = new VictorSPX(4);    

    public DriveTrain(){
        super();
    }
   public void periodic(){
   }
   // public void initDefaultCommand(){
     //   setDefaultCommand(new DriveTele(RobotContainer.mecanum));
    
   // }
    

    public void tankDrive(double left, double right){ 
        frontRightDrive.set(ControlMode.PercentOutput, right);
        frontLeftDrive.set(ControlMode.PercentOutput, left*-1);
        backLeftDrive.set(ControlMode.PercentOutput, left*-1);
        backRightDrive.set(ControlMode.PercentOutput, right);
        
    }
    public void mecanumDrive(double left, double right){
        frontRightDrive.set(ControlMode.PercentOutput, right);
        frontLeftDrive.set(ControlMode.PercentOutput, left);
        backLeftDrive.set(ControlMode.PercentOutput, left);
        backRightDrive.set(ControlMode.PercentOutput, right);
    }
    

    public void setMaxSpeed(double speed){
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
    }
}