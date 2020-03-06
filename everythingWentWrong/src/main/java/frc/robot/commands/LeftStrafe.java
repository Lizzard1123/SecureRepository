package frc.robot.commands;

import frc.robot.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.*;
import frc.robot.Constants;
public class LeftStrafe extends CommandBase{
    private double strafeSpeed;
    public LeftStrafe(DriveTrain driveTrain){
        addRequirements(driveTrain);
    }
    public void initialize(){
        strafeSpeed = SmartDashboard.getNumber("Strafe Speed", Constants.strafeSpeed);
    }
    public void execute(){
        strafeSpeed = SmartDashboard.getNumber("Strafe Speed", Constants.strafeSpeed);
        RobotContainer.mecanum.mecanumDrive(strafeSpeed, strafeSpeed*-1);
        isFinished();
    }
    public boolean isFinished(){
        return RobotContainer.stickMain.getLeftTrigger() ==0;
    }
    public boolean isInterrupted(){
        return RobotContainer.stickMain.getLeftJoyY() !=0 || RobotContainer.stickMain.getRightJoyY() !=0;
    }
    protected void end(){

    }
    protected void interrupted(){
        end();
    }
}