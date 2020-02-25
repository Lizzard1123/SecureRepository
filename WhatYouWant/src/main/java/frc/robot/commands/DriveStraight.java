package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
//import.edu.wpi.first.wpilibj.PIDController; 

public class DriveStraight extends CommandBase{//extends PIDCommand{
    private double thinking;
    public DriveStraight(double distance, DriveTrain smartBoi){
        addRequirements(smartBoi);
    }
    public void initialize(){
        //smartBoi.reset();
    }
    public void execute(){
        thinking = SmartDashboard.getNumber("Autonomous Drive Speed", 50)/100;
        RobotContainer.differential.differentialDrive(thinking*-1, thinking*-1);
    }
    public boolean isFinished(){
        return false;
    }
    protected void end(){

    }
    protected void interrupted(){
        
    }
}