package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LazySusan;
import frc.robot.RobotContainer;

public class SpinClockwise extends CommandBase{
    private double turnyTurny;
    public SpinClockwise(LazySusan lazy){
        addRequirements(lazy);
    }
    public void initialize(){

    }
    public void execute(){
        turnyTurny = SmartDashboard.getNumber("Lazy Susan Speed", 40);
        RobotContainer.susan.spinSusan(turnyTurny*-1);
    }
    public boolean isFinished(){
        return false;
    }
    protected void end(){

    }
    protected void interrupted(){
        
    }
}