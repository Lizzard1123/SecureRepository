/**
 * Purpose of this program is to follow up FarLeft_DriveForwardLowerArmGrabTwoTrenchBalls. 
 * The bot should turn around (somebody needs to measure what distance the wheels travel in order to make a 180).
 * (The bot might have to back up first)
 * After it turns around, it should go towards the lower goal, raise the arm to a certain distance, and spit out the balls.
 * Bot might have to back out of the way, but it currently just stops.
 */
package frc.robot.autonomousRoutines;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.commands.*;

public class FarLeft_TurnRightDriveForwardTurnRightSpitBalls extends SequentialCommandGroup{
    public FarLeft_TurnRightDriveForwardTurnRightSpitBalls(DriveTrain drive, Arm arm, Intake take, Encoder leftEnc, Encoder rightEnc){
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
