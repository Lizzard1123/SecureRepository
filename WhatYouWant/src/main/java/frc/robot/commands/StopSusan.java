package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LazySusan;
import frc.robot.RobotContainer;

public class StopSusan extends CommandBase{
    public StopSusan(LazySusan lazy){
        addRequirements(lazy);
    }
    public void initialize(){

    }
    public void execute(){
        RobotContainer.susan.spinSusan(0);
    }
    public boolean isFinished(){
        return false;
    }
    protected void end(){
        RobotContainer.susan.spinSusan(0);
    }
    protected void interrupted(){
        RobotContainer.susan.spinSusan(0);
    }
}