/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard; 
import frc.robot.commands.Autonomous;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.LazySusan;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.Limelight;
import frc.robot.commands.DriveTele;
import frc.robot.commands.SpinCounterClockwise;
import frc.robot.commands.SpinClockwise;
import frc.robot.commands.LiftArm;
import frc.robot.commands.LowerArm;
import frc.robot.commands.LiftLift;
import frc.robot.commands.LowerLift;
import frc.robot.subsystems.Intake;
import frc.robot.commands.TakeBall; 
import frc.robot.commands.ShootBall;
import frc.robot.commands.StopArm;
import frc.robot.commands.StopIntake;
import frc.robot.commands.StopLift;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static XBox stickMain = new XBox(0);
  public static XBox stickSecondary = new XBox(1);
  public static DriveTrain differential = new DriveTrain();
  public static LazySusan susan = new LazySusan();
  public static Arm arm = new Arm();
  public static Lift lift = new Lift();
  public static Intake take = new Intake();
  public static AnalogGyro gyro = new AnalogGyro(0); //double check port #
  public static Limelight lime = new Limelight();
  public static Autonomous m_autoCommand = new Autonomous(differential, arm, lime, take);
  //public static NetworkTable table = Robot.getTable();



  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    differential.setDefaultCommand(new DriveTele(differential));
    

    SmartDashboard.putNumber("Lift Arm Speed", Constants.armSpeed);
    SmartDashboard.putNumber("Lower Arm Speed", Constants.armSpeed);
    SmartDashboard.putNumber("Turtle", Constants.turtle);
    SmartDashboard.putNumber("Rabbit", Constants.rabbit);
    SmartDashboard.putNumber("Max Drive Speed", Constants.maxSpeed);
    SmartDashboard.putNumber("Intake Speed", Constants.intakeSpeed);
    SmartDashboard.putNumber("Eject Speed", Constants.intakeSpeed);
    SmartDashboard.putNumber("Lift Lift Speed", Constants.upSpeed);
    SmartDashboard.putNumber("Lower Lift Speed", Constants.downSpeed);
    SmartDashboard.putNumber("Lazy Susan Speed", Constants.lazySusanSpeed);
    SmartDashboard.putNumber("Autonomous Drive Speed", Constants.autoDriveSpeed);
    SmartDashboard.putNumber("Autonomous Drive Straight Timer", Constants.timer1);
    SmartDashboard.putNumber("Autonomous Timer 2", Constants.timer2);
    SmartDashboard.putString("Vision Processing", "on");
    // Configure the button bindings
    configureButtonBindings();


  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton liftArm = new JoystickButton(stickSecondary, XBox.LB_BUTTON);
    JoystickButton lowerArm = new JoystickButton(stickSecondary, XBox.RB_BUTTON);
    JoystickButton takeBall = new JoystickButton(stickSecondary, XBox.B_BUTTON);
    JoystickButton shootBall = new JoystickButton(stickSecondary, XBox.Y_BUTTON);
    JoystickButton susanClockwise = new JoystickButton(stickSecondary, XBox.A_BUTTON);
    JoystickButton susanCounterClockwise = new JoystickButton(stickSecondary, XBox.X_BUTTON);
    
    JoystickButton liftElevator = new JoystickButton(stickMain, XBox.A_BUTTON);
    JoystickButton lowerElevator = new JoystickButton(stickMain, XBox.X_BUTTON);

    JoystickButton stopArm1 = new JoystickButton(stickSecondary, XBox.LB_BUTTON);
    JoystickButton stopArm2 = new JoystickButton(stickSecondary, XBox.RB_BUTTON);
    JoystickButton stopIntake1 = new JoystickButton(stickSecondary, XBox.B_BUTTON);
    JoystickButton stopIntake2 = new JoystickButton(stickSecondary, XBox.Y_BUTTON);
    
    JoystickButton stopLift1 = new JoystickButton(stickMain, XBox.A_BUTTON);
    JoystickButton stopLift2 = new JoystickButton(stickMain, XBox.X_BUTTON);
  
     susanClockwise.whileHeld(new SpinClockwise(susan));
     susanCounterClockwise.whileHeld(new SpinCounterClockwise(susan));
     liftArm.whileHeld(new LiftArm(arm));
     lowerArm.whileHeld(new LowerArm(arm));
     liftElevator.whileHeld(new LiftLift(lift));
     lowerElevator.whileHeld(new LowerLift(lift));
     takeBall.whenHeld(new TakeBall(take));
     shootBall.whenHeld(new ShootBall(take));
     
     stopArm1.whenReleased(new StopArm(arm));
     stopArm2.whenReleased(new StopArm(arm));
     stopLift1.whenReleased(new StopLift(lift));
     stopLift2.whenReleased(new StopLift(lift));
     stopIntake1.whenReleased(new StopIntake(take));
     stopIntake2.whenReleased(new StopIntake(take));

    
     
 }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
