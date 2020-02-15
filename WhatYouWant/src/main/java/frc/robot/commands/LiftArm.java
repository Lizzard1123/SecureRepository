package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard; 

public class LiftArm extends CommandBase{
    private double armBoi;
    public LiftArm(Arm arm){
        addRequirements(arm);
    }
    public void initialize(){
    }
    public void execute(){
        armBoi = SmartDashboard.getNumber("ArmSpeed", 50);
        RobotContainer.arm.moveArm(armBoi*-1);
    }
    public boolean isFinished(){
        return false;
    }
    protected void end(){

    }
    protected void interrupted(){
        
    }
}