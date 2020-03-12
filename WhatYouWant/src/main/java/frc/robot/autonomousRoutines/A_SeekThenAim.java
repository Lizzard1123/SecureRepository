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