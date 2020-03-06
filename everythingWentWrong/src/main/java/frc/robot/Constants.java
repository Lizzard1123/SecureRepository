/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static double strafeSpeed= 40;
    public static double speedDivisor = 2;
    public static double maxSpeed = 70;
    public static double turtle = 40;
    public static double rabbit= 100;
    public static double slow = turtle*100;
    public static double fast = rabbit*100;
    public static double lazySusanSpeed;
    public static double armSpeed;
    public static double intakeSpeed;
    public static double upSpeed;
    public static double downSpeed = upSpeed/12;
  
    
}
