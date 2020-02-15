package frc.robot.commands; 

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain; 

public class Autonomous extends SequentialCommandGroup{
    public Autonomous(DriveTrain drive){
        RobotContainer.differential.differentialDrive(10, 10);
        //addCommands();
    }

}