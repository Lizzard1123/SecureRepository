package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard; 

public class LowerArm extends CommandBase{
    private double armBoi;
    public LowerArm(Arm arm){
        addRequirements(arm);
    }
    public void initialize(){

    }
    public void execute(){
        armBoi = SmartDashboard.getNumber("ArmSpeed", 50);
        RobotContainer.arm.moveArm(armBoi);
    }
    public boolean isFinished(){
        return false;
    }
    protected void end(){

    }
    protected void interrupted(){
        
    }
}