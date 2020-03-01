package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import edu.wpi.first.wpilibj.Timer;
//import.edu.wpi.first.wpilibj.PIDController; 

public class TurnRight extends CommandBase{//extends PIDCommand{
    private double thinking;
    private double endTime;
    private double startTime;
    private final Timer time = new Timer();
    //private Timer time = new Timer();
    public TurnRight(DriveTrain smartBoi){
        addRequirements(smartBoi);
    }
    public void initialize(){
        time.reset();
        time.start();
        startTime  = time.get();
        endTime = Constants.timer2;
    }
    public void execute(){
        endTime = SmartDashboard.getNumber("Autonomous Timer 2", Constants.timer2);
        thinking = SmartDashboard.getNumber("Autonomous Drive Speed", 50)/100;
        RobotContainer.differential.differentialDrive(0.02 + thinking*-1, thinking);
        /**
         * if(time.get()-startTime > endTime){
            return;
        }
         */
        isFinished();
        
    }
    @Override
    public boolean isFinished(){
        return time.get()-startTime > endTime;
    }
    protected void end(){
        RobotContainer.differential.differentialDrive(0,0);
        time.stop();
        time.reset();
    }
    protected void interrupted(){
        
    }
}