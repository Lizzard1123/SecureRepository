package frc.robot.commands; 

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Intake; 

public class Autonomous extends SequentialCommandGroup{
    public Autonomous(DriveTrain drive, Arm arm, Intake take){
        addCommands(
            parallel( 
                new DriveStraight(20, drive), 
                new AutoLowerArm(arm),
                new AutoTakeBall(take)
            ),
            new TurnRight(drive),
            parallel(
                new StopDrive(drive),
                new StopArm(arm),
                new StopIntake(take)
            )
            
        );
        
    }

}