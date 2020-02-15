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
        goinUp = SmartDashboard.getNumber("Up Speed", 30);
        RobotContainer.lift.wiggleLift(goinUp);
    }
    public boolean isFinished(){
        return false;
    }
    protected void end(){

    }
    protected void interrupted(){
        
    }
}