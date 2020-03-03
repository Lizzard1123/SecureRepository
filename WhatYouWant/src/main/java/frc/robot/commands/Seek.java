package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Limelight;

public class Seek extends CommandBase{

    public Seek(DriveTrain drive, Limelight lime){
        addRequirements(drive);

    }
    public void initialize(){

    }
    public void execute(){
        RobotContainer.lime.aim(RobotContainer.differential);
        
    }
    public boolean isFinished(){
        return false;
    }
    public boolean isInterrupted(){
        return false;

    }
    public void end(){

    }
    public void interrupted(){
        
    }




}