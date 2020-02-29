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
    private double startTime;
    private final Timer time = new Timer();
    //private Timer time = new Timer();
    public DriveStraight(double distance, DriveTrain smartBoi){
        addRequirements(smartBoi);
    }
    public void initialize(){
        startTime  = time.get();
        endTime = Constants.timer1;
    }
    public void execute(){
        endTime = SmartDashboard.getNumber("Autonomous Drive Straight Timer", Constants.timer1);
        thinking = SmartDashboard.getNumber("Autonomous Drive Speed", 50)/100;
        RobotContainer.differential.differentialDrive(thinking*-1, 0.016 + thinking*-1);
        
    }
    public boolean isFinished(){
        return time.get()-startTime > endTime;
    }
    protected void end(){
        RobotContainer.differential.differentialDrive(0,0);
    }
    protected void interrupted(){
        
    }
}