/**
 * When called upon, the arm motor moves at the speed specified on the SmartDashboard.
 * I hope you are as amused as I am when I named the variables and methods.
 * :D
 */
package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Lift;
import frc.robot.RobotContainer;

public class LowerLift extends CommandBase{

    private double downWeGo;
    public LowerLift(Lift lift){
        addRequirements(lift);
    }
    public void initialize(){

    }
    public void execute(){
        downWeGo = SmartDashboard.getNumber("Lower Lift Speed", 0);
        RobotContainer.lift.wiggleLift(downWeGo);
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