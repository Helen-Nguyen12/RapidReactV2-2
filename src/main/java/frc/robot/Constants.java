// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants //Note for self: Define integers here. Button numbers and the addresses of the motors. 
{
        //** Drive **//
    public static final int kFrontLeftChannel = 2; //For all of the drive motors
    public static final int kRearLeftChannel = 4;
    public static final int kFrontRightChannel = 1;
    public static final int kRearRightChannel = 3;
    public static final int kJoystickDriverChannel = 0; //For Joystick 0

        //** Intake **//
    public static final int intakeButtonNumber = 2;
    public static final int kIntakeChannel = 6;

        //** Shooter **//
    public static final int kJoystickShooterChannel = 1; //For Joystick 1 
    public static final int kShooterChannel = 5; //For the Shooter Motor
    public static final int shooterButtonNumber = 4; // For Shooter Button on the Gamepad
    public static final int kShooterGateForwardChannel = 4; //For use in pneumatics system (same with the one below)
    public static final int kShooterGateReleaseChannel = 5;

        //** Climb **//
     public static final int kClimbChannel = 7; //For Climb Motor
     public static final int kPistonClimbChannel = 6; //For piston
     public static final int kPistonReverseClimbChannel = 7; //For piston
     public static final int climbButtonNumber = 3; //For climb Button on the Gamepad
     public static final int cancellationButton1 = 5; //For climb's cancellation button on the Gamepad
     public static final int cancellationButton2 = 6; //For climb's cancellation button on the Gamepad
     public static final int addButtonNumber = 1; //For climb's adding one button on the Gamepad
     public static final int cancelStageButtonNumber = 2; //For climb's decrease stage button on the Gamepad
     public static final double ClimbMotorSpeed = 1.0; //Sets speed for climb motor
     public static final double InverseClimbMotorSpeed = -1.0; //Sets speed for climb motor
     public static final int upperClimbLimitSwitchChannel = 1; //Upper Limit Switch Channel
     public static final int lowerClimbLimitSwitchChannel = 0; //Lower Limit Switch Channel

     public static final double CLIMB_kP = 0.0002;
     public static final double CLIMB_kI = 0.000001;
     public static final double CLIMB_kD = 0.0004;
     public static final double CLIMB_MIN_OUTPUT = -6000.0;
     public static final double CLIMB_MAX_OUTPUT = 6000.0;

     public static final double climbDistance1 = 25; //Distance for fully extended
     public static final double climbDistance2 = 9; //Distance for 9 inches
     public static final double climbDistance3 = 23; //Distance for 23 inches
     public static final double climbDescendDistance = 2.5; //Distance for fully retracted

     public static final int kEncoderCountsPerRev = 42; //Ask about the encoder
     private static final double kArmDiameter = 0.75; //Arms' diameter in inches
     private static final double kGearBox = 1/16; //Gear Box ratio
     public static final double kCircumference = kArmDiameter * Math.PI; //Sets units to inches
     public static final double kEncoderPositionConversionFactor = kCircumference * kGearBox; //Sets encoder to read position in inches

}

