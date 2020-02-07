package frc.robot.subsystems;


//import frc.robot.commands.DriveTele;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
//import edu.wpi.first.wpilibj.Joystick;
//import frc.robot.RobotContainer;
import frc.robot.Constants;


public class DriveTrain extends SubsystemBase{
    public final Spark frontRightDrive = new Spark(0);
    public final Spark frontLeftDrive = new Spark(1);
    public final Spark backLeftDrive = new Spark(2);
    public final Spark backRightDrive = new Spark(3);

    public MecanumDrive drive = new MecanumDrive(frontLeftDrive, backLeftDrive, frontRightDrive, backRightDrive);


    public DriveTrain(){
        super();

        addChild("Drive", drive);
        SmartDashboard.getNumber("Max Drive Speed", 100);
        //SmartDashboard.putNumber("Max Drive Speed", Constants.maxSpeed);
        SmartDashboard.putNumber("Turtle", Constants.turtle);
    }
   public void periodic(){
       drive.check();
       if(!(drive.isSafetyEnabled())){
           drive.setSafetyEnabled(true);
       } 
   }
   // public void initDefaultCommand(){
     //   setDefaultCommand(new DriveTele(RobotContainer.mecanum));
    
   // }
    

    public void mecanumDrive(double left, double right, double turtle, double rabbit)   { 
        turtle = turtle/(Constants.speedDivisor);
        rabbit = rabbit/(Constants.speedDivisor);
        if(left>5 && turtle>0 && rabbit<5 && (left-turtle)>0){left = left - turtle;}
        if(right>5 && turtle>0 && rabbit<5 && (right-turtle)>0){right = right - turtle;}
        if(left<-5 && turtle>0 && rabbit<5 && (left+turtle)<0){left = left + turtle;}
        if(right<-5 && turtle>0 && rabbit<5 && (right+turtle)<0){right = right + turtle;}

        //dead speed
        if(left<5 && left>-5){left = 0;}
        if(right<5 && right>-5){right = 0;}
        

        //strafe
        if( (left>0 && right<0) ||
            (right>0 && left<0)

        ){
            //side going out is side moving towards
            if(left>0 && right<0){ //goes right
                frontLeftDrive.set(left);
                backLeftDrive.set(left*-1);
                frontRightDrive.set(right*-1);
                backRightDrive.set(right);
            }
            else if(left<0 && right>0){ //goes left
                frontLeftDrive.set(left);
                backLeftDrive.set(left*-1);
                frontRightDrive.set(right*-1);
                backRightDrive.set(right);
            }
        }
        else{
            frontLeftDrive.set(left*-1);
            backLeftDrive.set(left*-1);
            frontRightDrive.set(right);
            backRightDrive.set(right);
        }
      

        
    }
    

    public void setSpeed(double speed){
        drive.setMaxOutput(speed);
    }
}