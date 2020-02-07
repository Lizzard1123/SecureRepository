package frc.robot.commands; 

import edu.wpi.first.wpilibj2.command.CommandBase; 
import frc.robot.RobotContainer; 
import frc.robot.subsystems.DriveTrain;
import frc.robot.Constants; 

public class DriveTele extends CommandBase{
    public DriveTele(DriveTrain driveTrain){
        addRequirements(driveTrain); 
    }
    public void initialize(){
        RobotContainer.differential.setSpeed(Constants.maxSpeed);
    }
    public void execute(){
        RobotContainer.differential.differentialDrive(RobotContainer.stick.getLeftJoyY(), RobotContainer.stick.getRightJoyY());
    }
    public boolean isFinished(){
        return false; 
    }
    protected void end(){

    }
    protected void interrupted(){

    }
}