package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Constants; 

public class AutoTakeBall extends CommandBase{
    private double myBall;
    private double endTime;
    private double startTime;
    private final Timer time = new Timer();
    public AutoTakeBall(Intake take){
        addRequirements(take);
    }
    public void initialize(){
        time.reset();
        time.start();
        startTime  = time.get();
        endTime = Constants.timer1; 
    }
    public void execute(){
        endTime = SmartDashboard.getNumber("Autonomous Drive Straight Timer", Constants.timer1);
        myBall = SmartDashboard.getNumber("Intake Speed", 50);
        RobotContainer.take.yellowBoi(myBall);
        isFinished();
    }
    public boolean isFinished(){
        return time.get()-startTime > endTime;
    }
    protected void end(){
        RobotContainer.take.yellowBoi(0);
        time.stop();
        time.reset();
    }
    protected void interrupted(){
        RobotContainer.take.yellowBoi(0);   
    }
}