package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LazySusan;
import frc.robot.RobotContainer;

public class SpinCounterClockwise extends CommandBase{
    private double whee;
    public SpinCounterClockwise(LazySusan lazy){
        addRequirements(lazy);
    }
    public void initialize(){

    }
    public void execute(){
        whee = SmartDashboard.getNumber("Lazy Susan Speed", 10);
        RobotContainer.susan.spinSusan(whee);
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