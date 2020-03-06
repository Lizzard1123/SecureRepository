package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
//import frc.robot.subsystems.*;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;
//import frc.robot.Constants;

public class DriveTele extends CommandBase{
    private double maxSpeed;
    public DriveTele(DriveTrain driveTrain){
        addRequirements(driveTrain);
    }
    public void initialize(){
       maxSpeed = SmartDashboard.getNumber("Max Drive Speed", Constants.maxSpeed);
    }
    public void execute(){
        RobotContainer.mecanum.setMaxSpeed(maxSpeed);
        RobotContainer.mecanum.tankDrive(
            RobotContainer.stickMain.getLeftJoyY()/100, 
            RobotContainer.stickMain.getRightJoyY()/100);
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