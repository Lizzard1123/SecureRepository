package frc.robot.commands; 

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Arm; 

public class Autonomous extends SequentialCommandGroup{
    public Autonomous(DriveTrain drive, Arm arm){
        addCommands(
            parallel( 
                new DriveStraight(20, drive)//, 
                //new LowerArm(arm)
            )
            
        );
        
    }

}