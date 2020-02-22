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
        armBoi = SmartDashboard.getNumber("Lift Arm Speed", 0);
    }
    public void execute(){
        
        RobotContainer.arm.moveArm(armBoi);
    }
    public boolean isFinished(){
        return true;
    }
    public boolean isCanceled(){
        return true;
    }
    protected void end(){
        RobotContainer.arm.moveArm(0);
    }
    protected void interrupted(){
        RobotContainer.arm.moveArm(0);
    }
}