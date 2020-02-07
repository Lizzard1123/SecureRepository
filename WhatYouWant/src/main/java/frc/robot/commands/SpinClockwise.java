package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LazySusan;
import frc.robot.Constants;
import frc.robot.RobotContainer;

public class SpinClockwise extends CommandBase{
    public SpinClockwise(LazySusan lazy){
        addRequirements(lazy);
    }
    public void initialize(){

    }
    public void execute(){
        RobotContainer.susan.spinSusan(Constants.lazySusanSpeed*-1);
    }
    public boolean isFinished(){
        return false;
    }
    protected void end(){

    }
    protected void interrupted(){
        
    }
}