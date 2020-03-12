package frc.robot.commands;
import frc.robot.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;
import frc.robot.Constants;

public class RightStrafe extends CommandBase{
    private DriveTrain drive = new DriveTrain();
    private double maxStrafeSpeed;
    public RightStrafe(DriveTrain driveTrain){
        drive = driveTrain;
        //addRequirements(driveTrain);
    }
    public void initialize(){
       maxStrafeSpeed = SmartDashboard.getNumber("Strafe Speed", Constants.strafeSpeed);

    }
    public void execute(){
        maxStrafeSpeed = SmartDashboard.getNumber("Strafe Speed", Constants.strafeSpeed);
        drive.mecanumDrive(
            RobotContainer.stickMain.getRightTrigger(), 
            RobotContainer.stickMain.getRightTrigger());
        isFinished();
    }
    public boolean isFinished(){
        return RobotContainer.stickMain.getRightTrigger() ==0;
    }
    public boolean isInterrupted(){
        return RobotContainer.stickMain.getLeftJoyY() !=0 || RobotContainer.stickMain.getRightJoyY() !=0;
    }
    protected void end(){

    }
    protected void interrupted(){
        end();
    }
}