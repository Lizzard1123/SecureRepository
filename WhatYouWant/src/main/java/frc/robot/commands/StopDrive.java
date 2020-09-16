/**
 * After the arm incident, we decided to make this class, as well. It has no use for teleop, so it's only utilized during autonomous.
 */
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.RobotContainer;

public class StopDrive extends CommandBase{
    public StopDrive(DriveTrain drive){
        addRequirements(drive);
    }
    public void initialize(){
    }
    public void execute(){
        
        RobotContainer.differential.differentialDrive(0, 0);
    }
    public boolean isFinished(){
        return true;
    }
    protected void end(){
        RobotContainer.differential.differentialDrive(0, 0);
    }
    protected void interrupted(){
        RobotContainer.differential.differentialDrive(0, 0);
    }
}