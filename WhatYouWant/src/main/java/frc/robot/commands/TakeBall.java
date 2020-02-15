package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class TakeBall extends CommandBase{
    public TakeBall(Intake take){
        addRequirements(take);
    }
    public void initialize(){

    }
    public void execute(){
        RobotContainer.take.yellowBoi(Constants.intakeSpeed);
    }
    public boolean isFinished(){
        return false;
    }
    protected void end(){

    }
    protected void interrupted(){
        
    }
}