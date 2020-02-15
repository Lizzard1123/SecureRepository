package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.RobotContainer;

public class ShootBall extends CommandBase{
    private double shootinTootin;
    public ShootBall(Intake take){
        addRequirements(take);
    }
    public void initialize(){

    }
    public void execute(){
        shootinTootin = SmartDashboard.getNumber("Intake Speed", 50);
        RobotContainer.take.yellowBoi(shootinTootin*-1);
    }
    public boolean isFinished(){
        return false;
    }
    protected void end(){

    }
    protected void interrupted(){
        
    }
}