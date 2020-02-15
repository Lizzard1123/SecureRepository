package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.RobotContainer;

public class TakeBall extends CommandBase{
    private double myBall;
    public TakeBall(Intake take){
        addRequirements(take);
    }
    public void initialize(){

    }
    public void execute(){
        myBall = SmartDashboard.getNumber("Intake Speed", 50);
        RobotContainer.take.yellowBoi(myBall);
    }
    public boolean isFinished(){
        return false;
    }
    protected void end(){

    }
    protected void interrupted(){
        
    }
}