/**
 * Spits out ball by spinning roller
 */
package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.RobotContainer;

public class ShootBall extends CommandBase{
    private double shootinTootin; //rootin' tootin' spittin' shootin'
    public ShootBall(Intake take){
        addRequirements(take);
    }
    public void initialize(){

    }
    //grabs variable from SmartDashboard and makes that the outtake speed
    public void execute(){
        shootinTootin = SmartDashboard.getNumber("Eject Speed", 50);
        RobotContainer.take.yellowBoi(shootinTootin*-1);
    }
    public boolean isFinished(){
        return true;
    }
    protected void end(){
        RobotContainer.take.yellowBoi(0);
    }
    protected void interrupted(){
        RobotContainer.take.yellowBoi(0);
    }
}

//if you're ever having a mental breakdown while coding, listen to some Billy Joel
//♫ We didn't start the fire ♫
//rip west coast bc of a gender reveal party