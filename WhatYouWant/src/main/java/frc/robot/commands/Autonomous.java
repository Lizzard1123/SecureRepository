/**
 * This class is called upon during the autonomous section of the match.
 * Call upon one of the classes in the autonomousRoutines folder to change what happens during the match.
 * Making separate files for different autonomous functions we want to do give us more options of what we want to accomplish during
 * the autonomous section.
 * I should also note that the classes in autonomousRoutines grab commands from the commands folder.
 * If I remember correctly, all commands, both autonomous and teleop, have to be in the same folder.
 * I'm not sure why, but I think it has to do with importing files in subsystems or something.
 * I dunno; I'm only commenting because the past two lectures in my CS2500 class were discussing readability and cohesion.
 * I wanna be a good programmer! :)
 */
package frc.robot.commands;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
//import frc.robot.autonomousSubroutines.*;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Limelight;

public class Autonomous extends SequentialCommandGroup{
    public Autonomous(DriveTrain drive, Arm arm, Limelight lime, Intake take, Encoder leftEnc, Encoder rightEnc){
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