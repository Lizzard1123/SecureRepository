package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class LiftArm extends CommandBase{
    public LiftArm(Arm arm){
        addRequirements(arm);
    }
    public void initialize(){

    }
    public void execute(){
        RobotContainer.arm.moveArm(Constants.armSpeed*-1);
    }
    public boolean isFinished(){
        return false;
    }
    protected void end(){

    }
    protected void interrupted(){
        
    }
}