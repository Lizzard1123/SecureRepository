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