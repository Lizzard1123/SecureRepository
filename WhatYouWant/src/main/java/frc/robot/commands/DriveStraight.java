package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.wpilibj.Timer;
//import.edu.wpi.first.wpilibj.PIDController; 

public class DriveStraight extends CommandBase{//extends PIDCommand{
    private double thinking;
    private double endTime;
    //private Timer time = new Timer();
    public DriveStraight(double distance, DriveTrain smartBoi){
        addRequirements(smartBoi);
    }
    public void initialize(){
        endTime = Constants.timer1;
    }
    public void execute(){
        
        thinking = SmartDashboard.getNumber("Autonomous Drive Speed", 50)/100;
        RobotContainer.differential.differentialDrive(thinking*-1, thinking*-1);
        
    }
    public boolean isFinished(){
        return System.currentTimeMillis() >= endTime*1000;
    }
    protected void end(){
        RobotContainer.differential.differentialDrive(0,0);
    }
    protected void interrupted(){
        
    }
}