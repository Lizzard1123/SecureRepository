package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Lift;
import frc.robot.RobotContainer;

public class LiftLift extends CommandBase{
    private double goinUp;
    public LiftLift(Lift lift){
        addRequirements(lift);
    }
    public void initialize(){

    }
    public void execute(){
        goinUp = SmartDashboard.getNumber("Lift Lift Speed", 0);
        RobotContainer.lift.wiggleLift(goinUp*-1);
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