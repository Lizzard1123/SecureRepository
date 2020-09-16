/**
 * Purpose of this program is for the robot to start on the far left of the field and grab two balls in the trench.
 * (I'm not sure what left this is relative to.)
 * The robot should drive forward, lower arm, and start intake for long enough to grab two balls.
 * Be sure to measure the distance it has to travel because it will drive to a certain distance, not a set amount of time.
 */
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