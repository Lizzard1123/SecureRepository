package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Lift;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class LowerLift extends CommandBase{
    public LowerLift(Lift lift){
        addRequirements(lift);
    }
    public void initialize(){

    }
    public void execute(){
        RobotContainer.lift.wiggleLift(Constants.downSpeed);
    }
    public boolean isFinished(){
        return false;
    }
    protected void end(){

    }
    protected void interrupted(){
        
    }
}