package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj2.command.PIDCommand;
//import.edu.wpi.first.wpilibj.PIDController; 

public class DriveToDistance extends CommandBase{//extends PIDCommand{
    private Encoder leftEnc;
    private Encoder rightEnc;
    private double distance;
    public DriveToDistance(double distanceInches, DriveTrain smartBoi, Encoder leftEnc, Encoder rightEnc){
        this.leftEnc = leftEnc;
        this.rightEnc = rightEnc;
        distance = distanceInches;
    }
    public void initialize(){
        
    }
    public void execute(){
        double thinking = SmartDashboard.getNumber("Autonomous Drive Speed", 40);
        RobotContainer.differential.differentialDrive(thinking*-1, thinking*-1);
       
        //might delete this
        isFinished();
        
    }
    //if this returns true, calls end() function
    @Override
    public boolean isFinished(){
        return leftEnc.getDistance() >= distance && rightEnc.getDistance() >= distance;
    }
    protected void end(){
        RobotContainer.differential.differentialDrive(0,0);
    }
    protected void interrupted(){
        
    }
}