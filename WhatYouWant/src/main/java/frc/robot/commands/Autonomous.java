package frc.robot.commands; 

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
//import frc.robot.autonomousSubroutines.*;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Limelight;

public class Autonomous extends SequentialCommandGroup{
    public Autonomous(DriveTrain drive, Arm arm, Limelight lime, Intake take){
        addCommands(
           new Seek(drive, lime)
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