/**
 * When called upon, the arm motor moves at the speed specified on the SmartDashboard.
 */
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
        armBoi = SmartDashboard.getNumber("Lower Arm Speed", 0);
    }
    public void execute(){    
        RobotContainer.arm.moveArm(armBoi*-1);
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