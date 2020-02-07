package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
//import frc.robot.subsystems.*;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;
//import frc.robot.Constants;

public class DriveTele extends CommandBase{
    public DriveTele(DriveTrain driveTrain){
        addRequirements(driveTrain);
    }
    public void initialize(){
       // RobotContainer.mecanum.setSpeed(Constants.maxSpeed);
    }
    public void execute(){
        RobotContainer.mecanum.mecanumDrive(
            RobotContainer.stickMain.getLeftJoyY()/(Constants.speedDivisor), 
            RobotContainer.stickMain.getRightJoyY()/(Constants.speedDivisor),
            RobotContainer.stickMain.getLeftTrigger()+100,
            RobotContainer.stickMain.getRightTrigger()+100);
    }
    //-Constants.cruiseSpeed
    //-Constants.cruiseSpeed
    public boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    
}