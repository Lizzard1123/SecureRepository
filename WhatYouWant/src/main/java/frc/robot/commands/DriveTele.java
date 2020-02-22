package frc.robot.commands; 

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase; 
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
        RobotContainer.differential.setSpeed(maxDrive/100);
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