/**
 * Purpose of this class is to instantiate a function that can be called upon when making autonomous code.
 * For some reason unbeknownst to me, armBoi cannot grab the value from the SmartDashboard in initialize(), so it has to be in execute.
 * This also allows for any changes that need to be made for specifically autonomous movement with the arm that might affect 
 * the LowerArm.java class such as the timer stuff (thx Colin)
 */
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Constants; 

public class AutoLowerArm extends CommandBase{
    private double armBoi;
    private double endTime;
    private double startTime;
    private final Timer time = new Timer();
    public AutoLowerArm(Arm arm){
        addRequirements(arm);
    }
    public void initialize(){
        time.reset();
        time.start();
        startTime  = time.get()+1;
        endTime = Constants.timer1; 
    }
    public void execute(){
        endTime = SmartDashboard.getNumber("Autonomous Drive Straight Timer", Constants.timer1);
        armBoi = SmartDashboard.getNumber("Lift Arm Speed", 0);
        RobotContainer.arm.moveArm(armBoi*-1);
        isFinished();
    }
    public boolean isFinished(){
        return time.get()-startTime > endTime-1;
    }
    protected void end(){
        RobotContainer.arm.moveArm(0);
        time.stop();
        time.reset();
    }
    protected void interrupted(){
        RobotContainer.arm.moveArm(0);
    }
}