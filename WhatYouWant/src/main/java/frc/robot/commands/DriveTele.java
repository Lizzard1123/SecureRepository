/**
 * This command is called upon during the teleop period, hence the name.
 * 
 */
package frc.robot.commands; 

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer; 
import frc.robot.subsystems.DriveTrain;

public class DriveTele extends CommandBase{
    private double maxDrive;
    public DriveTele(DriveTrain driveTrain){
        addRequirements(driveTrain);

    }
    //grabs maxDrive speed from SmartDashboard, if none, maxDrive = 100
    public void initialize(){        
        maxDrive = SmartDashboard.getNumber("Max Drive Speed", 100);
        
    }
    //if certain buttons are pressed, the speed changes
    //.getNumber("Value", double value) looks for the variable on the smartdashboard in the quotes, if it doesn't find it, 
    //returns the double value instead
    //(it MIGHT make a variable named with the tag in quotes and instantiates it to the double value but its been 6 months
    //and I've since forgotten) :pensive:
    public void execute(){
       
        if(RobotContainer.stickMain.getButtonLB()){
            maxDrive = SmartDashboard.getNumber("Turtle", Constants.turtle);
        }
        else if(RobotContainer.stickMain.getButtonRB()){
            maxDrive = SmartDashboard.getNumber("Rabbit", Constants.rabbit);
        }
        else{
            maxDrive = SmartDashboard.getNumber("Max Drive Speed", 100);
        }
        //.setSpeed(double speed) sets max speed of motors
        RobotContainer.differential.setSpeed(maxDrive);
        //motors will go at speed of how far joystick is pushed,
        //so if the joystick is pushed all the way, the motors will go 1 * maxDrive
        //if joystick is pushed halfway, the motors will go .5 * maxDrive
        //if joystick is pulled back halfway, the motors will go -.5* maxDrive
        //the joystick is the joysticks on something like an XBox controller, but we b broke hoes
        RobotContainer.differential.differentialDrive(RobotContainer.stickMain.getLeftJoyY(), RobotContainer.stickMain.getRightJoyY());
    }
    public boolean isFinished(){
        return false; 
    }
    protected void end(){

    }
    protected void interrupted(){
        //end();
    }
}