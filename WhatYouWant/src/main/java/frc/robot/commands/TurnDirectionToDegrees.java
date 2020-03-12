package frc.robot.commands;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.RobotContainer;

public class TurnDirectionToDegrees extends CommandBase{
    private DriveTrain drive;
    private double degrees;
    private String direction;
    public TurnDirectionToDegrees(double degrees, String direction, DriveTrain drive, Encoder leftEnc, Encoder rightEnc){
        this.degrees = degrees;
        this.drive = drive;
        this.direction = direction;
    }
    public void initialize(){
        if(direction.toUpperCase().equals("left")){

        }

    }
    public void execute(){
        double rotateSpeed = SmartDashboard.getNumber("Autonomous Drive Speed", 40);
        
    }
    public boolean isFinished(){
        return true;
    }
    protected void end(){
        RobotContainer.take.yellowBoi(0);
    }
    protected void interrupted(){
        RobotContainer.take.yellowBoi(0);   
    }
}