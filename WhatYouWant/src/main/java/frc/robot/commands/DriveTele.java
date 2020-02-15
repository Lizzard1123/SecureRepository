package frc.robot.commands; 

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase; 
import frc.robot.RobotContainer; 
import frc.robot.subsystems.DriveTrain;
import frc.robot.Constants; 
import frc.robot.XBox;

public class DriveTele extends CommandBase{
    /*
    private double leftSpeed;
    private double rightSpeed;
    */
    public DriveTele(DriveTrain driveTrain){//, XBox joy){
        addRequirements(driveTrain);

        /*
        leftSpeed = joy.getLeftJoyY();
        rightSpeed = joy.getRightJoyY();
        */
    }
    public void initialize(){
        //RobotContainer.differential.setSpeed(Constants.maxSpeed);
    }
    public void execute(){
        SmartDashboard.putNumber("Turtle",Constants.turtle);
        SmartDashboard.putNumber("Rabbit", Constants.rabbit);
        SmartDashboard.putNumber("Max Speed", Constants.maxSpeed);
        RobotContainer.differential.differentialDrive(RobotContainer.stickMain.getLeftJoyY()-30, RobotContainer.stickMain.getRightJoyY()-30);
    }
    public boolean isFinished(){
        return false; 
    }
    protected void end(){

    }
    protected void interrupted(){
        //end();
    }
}