package frc.robot.commands; 

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer; 
import frc.robot.subsystems.DriveTrain;

public class DriveTele extends CommandBase{
    private double maxDrive;
    public DriveTele(DriveTrain driveTrain){
        addRequirements(driveTrain);

    }
    public void initialize(){        
        maxDrive = SmartDashboard.getNumber("Max Drive Speed", 100);
    }
    public void execute(){
        if(RobotContainer.stickMain.getButtonLB()){
            maxDrive = SmartDashboard.getNumber("Turtle", Constants.turtle);
        }
        if(RobotContainer.stickMain.getButtonRB()){
            maxDrive = SmartDashboard.getNumber("Rabbit", Constants.rabbit);
        }
        else{
            maxDrive = SmartDashboard.getNumber("Max Drive Speed", 100);
        }
        RobotContainer.differential.setSpeed(maxDrive);
        RobotContainer.differential.differentialDrive(RobotContainer.stickMain.getLeftJoyY(), RobotContainer.stickMain.getRightJoyY());
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