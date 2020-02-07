package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class LowerArm extends CommandBase{
    public LowerArm(Arm arm){
        addRequirements(arm);
    }
    public void initialize(){

    }
    public void execute(){
        RobotContainer.arm.moveArm(Constants.armSpeed);
    }
    public boolean isFinished(){
        return false;
    }
    protected void end(){

    }
    protected void interrupted(){
        
    }
}