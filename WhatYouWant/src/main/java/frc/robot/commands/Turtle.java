package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard; 

public class Turtle extends CommandBase{
    public static boolean slowBoi;
    public Turtle(DriveTrain drive){
        addRequirements(drive);
    }
    public void initialize(){

    }
    public void execute(){
        slowBoi = true;
    }
    public boolean isFinished(){
        return true;
    }
    public boolean isCanceled(){
        return true;
    }
    protected void end(){
        slowBoi = false;
    }
    protected void interrupted(){
        slowBoi = false;
    }
}