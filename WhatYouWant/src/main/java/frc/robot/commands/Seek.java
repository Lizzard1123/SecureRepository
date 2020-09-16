/**
 * Uses limelight's API to move around and look for the reflective taped target.
 */
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Limelight;

public class Seek extends CommandBase{
    public static double leftDriveAdjust =0;
    public static double rightDriveAdjust = 0;
    public Seek(DriveTrain drive, Limelight lime){
        addRequirements(drive);

    }
    public void initialize(){

    }
    public void execute(){
        leftDriveAdjust =RobotContainer.lime.getAimAdjust(); // Constants.autoDriveSpeed + 
        rightDriveAdjust = RobotContainer.lime.getAimAdjust(); // Constants.autoDriveSpeed + 

        RobotContainer.lime.seek(RobotContainer.differential);
        RobotContainer.differential.differentialDrive(leftDriveAdjust, rightDriveAdjust); //moves robot in direction of adjustment
        
    }
    public boolean isFinished(){
        return false;
    }
    public boolean isInterrupted(){
        return false;

    }
    public void end(){

    }
    public void interrupted(){
        
    }




}