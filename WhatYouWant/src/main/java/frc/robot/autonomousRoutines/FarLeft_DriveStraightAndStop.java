/**
 * Purpose of this program is to start on the far left of the field, drive straight, then stop.
 * The bot will drive to a specified distance.
 */
package frc.robot.autonomousRoutines;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.commands.*;

public class FarLeft_DriveStraightAndStop extends SequentialCommandGroup{
    public FarLeft_DriveStraightAndStop(DriveTrain drive, Arm arm, Intake take, Encoder leftEnc, Encoder rightEnc){
        addCommands(
            new DriveToDistance(57, drive, leftEnc, rightEnc),
            new StopDrive(drive)
            
        );
        
    }

}