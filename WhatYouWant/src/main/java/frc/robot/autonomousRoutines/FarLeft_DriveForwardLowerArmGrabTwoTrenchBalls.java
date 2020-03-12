package frc.robot.autonomousRoutines;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.commands.*;

public class FarLeft_DriveForwardLowerArmGrabTwoTrenchBalls extends SequentialCommandGroup{
    public FarLeft_DriveForwardLowerArmGrabTwoTrenchBalls(DriveTrain drive, Arm arm, Intake take, Encoder leftEnc, Encoder rightEnc){
        addCommands(
            parallel(
                new DriveToDistance(57, drive, leftEnc, rightEnc),
                new LowerArm(arm),
                new TakeBall(take)
            ),
            new StopDrive(drive)
            
        );
        
    }

}