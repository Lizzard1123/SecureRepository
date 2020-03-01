package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Constants; 

public class AutoLiftArm extends CommandBase{
    private double armBoi;
    private double endTime;
    private double startTime;
    private final Timer time = new Timer();
    public AutoLiftArm(Arm arm){
        addRequirements(arm);
    }
    public void initialize(){
        time.reset();
        time.start();
        startTime  = time.get();
        endTime = Constants.timer1; 
    }
    public void execute(){
        armBoi = SmartDashboard.getNumber("Lift Arm Speed", 0);
        RobotContainer.arm.moveArm(armBoi);
        isFinished();
    }
    public boolean isFinished(){
        return time.get()-startTime > endTime;
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