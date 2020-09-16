/**
 * Maybe because these functions are mapped to a button...?
 * Whatever.
 * Stops the intake after TakeBall and ShootBall are no longer being called upon.
 */
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.RobotContainer;

public class StopIntake extends CommandBase{
    public StopIntake(Intake take){
        addRequirements(take);
    }
    public void initialize(){

    }
    public void execute(){
        RobotContainer.take.yellowBoi(0);
    }
    public boolean isFinished(){
        return false;
    }
    protected void end(){
        RobotContainer.take.yellowBoi(0);
    }
    protected void interrupted(){
        RobotContainer.take.yellowBoi(0);
    }
}