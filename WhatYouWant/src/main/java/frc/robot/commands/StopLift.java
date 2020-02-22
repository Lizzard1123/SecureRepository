package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Lift;
import frc.robot.RobotContainer;

public class StopLift extends CommandBase{
    public StopLift(Lift lift){
        addRequirements(lift);
    }
    public void initialize(){

    }
    public void execute(){
        RobotContainer.lift.wiggleLift(0);
    }
    public boolean isFinished(){
        return true;
    }
    protected void end(){
        RobotContainer.lift.wiggleLift(0);
    }
    protected void interrupted(){
        RobotContainer.lift.wiggleLift(0);
    }
}