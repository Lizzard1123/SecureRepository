package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;
import frc.robot.RobotContainer;

public class StopArm extends CommandBase{
    public StopArm(Arm arm){
        addRequirements(arm);
    }
    public void initialize(){
    }
    public void execute(){
        
        RobotContainer.arm.moveArm(0);
    }
    public boolean isFinished(){
        return true;
    }
    protected void end(){
        RobotContainer.arm.moveArm(0);
    }
    protected void interrupted(){
        RobotContainer.arm.moveArm(0);
    }
}