/**
 * Pupose of this program is to use the DriveTrain, Arm, Limelight, and Intake objects to seek then aim then shoot.
 * (I know the name of this file is misleading)
 * The robot should move forward, and using the limelight, search and then lock onto the upper target.
 * (There is no reflective tape on the lower goal)
 * Once the target is found, the bot should move into position and dump the balls into the lower hatch.
 */
package frc.robot.autonomousRoutines; 

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Limelight;
import frc.robot.commands.*;

public class A_SeekThenAim extends SequentialCommandGroup{
    public A_SeekThenAim(DriveTrain drive, Arm arm, Limelight lime, Intake take){
        addCommands(
           new Aim(drive, lime)
            /**
             *  parallel( 
                new DriveStraight(20, drive)//, 
                //new LowerArm(arm)
            ),
            new StopDrive(drive)
             *  */            
        );
        
    }

}