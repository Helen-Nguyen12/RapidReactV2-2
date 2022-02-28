package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class Climb extends SubsystemBase {
    private CANSparkMax m_climbMotor; // Initalizes motor
    private static DoubleSolenoid m_climbPiston; // Initalizes pistons
    private DigitalInput m_upperClimbLimitSwitch; // Initalizes upper limit switch
    private DigitalInput m_lowerClimbLimitSwitch; // Initalizes lower limit switch
    private RelativeEncoder m_climbEncoder; // Initalizes encoder
    public static int m_climbValue = 0; // Initalizes value
    private static SparkMaxPIDController m_climbPID; // Initalizes PID
    private static String climbMessage = "Example";

    public Climb() {
        m_climbMotor = RobotContainer.climbMotor; // References the object from Robot Container so I don't need to
                                                  // recreate the motor
        m_climbPiston = RobotContainer.climbPiston; // References the object from Robot Container so I don't need to
                                                    // recreate the pistons
        m_climbEncoder = RobotContainer.climbEncoder; // References the encoder from Robot Container
        m_upperClimbLimitSwitch = RobotContainer.upperClimbLimitSwitch; // Limit switch to test if Pivot Arms is
                                                                        // extended
        m_lowerClimbLimitSwitch = RobotContainer.lowerClimbLimitSwitch; // Limit switch to test if Pivot Arms has
                                                                        // descended
        // m_climbValue = RobotContainer.climbValue;
        m_climbPID = RobotContainer.climbMotorPID;
    }

    // 0 is closed, 1 is open
    public void periodic() {
        // Limit Switches display on SmartDashboard
        SmartDashboard.putBoolean("Lower Climb Limit Switch", RobotContainer.lowerClimbLimitSwitch.get());
        SmartDashboard.putBoolean("Upper Climb Limit Switch", RobotContainer.upperClimbLimitSwitch.get());
        // Climb Encoder display on SmartDashboard
        SmartDashboard.putNumber("Climb Encoder", RobotContainer.climbEncoder.getPosition()); // Measures in units of
                                                                                              // rotations by default
    }

    public void raisePivotArms(double speed) {
        m_climbMotor.set(speed);
    }

    public void descendPivotArms(double speed) {
        m_climbMotor.set(speed);
    }

    public void pistonRelease() {
        // m_climbPiston.set(DoubleSolenoid.Value.kForward);
        System.out.println("HHHEJEK");
    }

    public void pistonRetract() {
        m_climbPiston.set(DoubleSolenoid.Value.kReverse);
    }

    public void increaseStage() {
        m_climbValue++;
    }

    public void climbSequence() { // If climb is > 0, set to 0 || test with cancelstage- Cannot change to
                                  // Static!!!
        if (m_climbValue <= -1) {
            int m_climbValue = 0;
        } else if (m_climbValue == 0) {
            climbMessage = "Ready to raise Pivot Arms?";
            SmartDashboard.putString("Climb", climbMessage);
        } else if (m_climbValue == 1) { // Raise Pivot Arms ||Maybe add if statement in raisePivotArms function?
            m_climbPiston.set(DoubleSolenoid.Value.kForward);
            climbMessage = "Raising Pivot Arms";
            SmartDashboard.putString("ClimbArms", climbMessage);
            m_climbPID.setReference(Constants.climbDistance1, ControlType.kPosition);
            climbMessage = "Ready to descend Pivot Arms?";
            SmartDashboard.putString("Climb", climbMessage);
        } else if (m_climbValue == 2) { // Descend Pivot Arms- Should be on latches
            climbMessage = "Descending Pivot Arms";
            SmartDashboard.putString("ClimbArms", climbMessage);
            m_climbPID.setReference(Constants.climbDescendDistance, ControlType.kPosition);
            climbMessage = "Ready to raise Pivot Arms?";
            SmartDashboard.putString("Climb", climbMessage);
        } else if (m_climbValue == 3) { // Piston retracts, extends climb, piston extends, then climb extends again
            pistonRetract();
            m_climbPiston.set(DoubleSolenoid.Value.kReverse);
            climbMessage = "Raising Pivot Arms";
            SmartDashboard.putString("ClimbArms", climbMessage);
            m_climbPID.setReference(Constants.climbDistance2, ControlType.kPosition);
            pistonRelease();
            m_climbPiston.set(DoubleSolenoid.Value.kForward);
            m_climbPID.setReference(Constants.climbDistance3, ControlType.kPosition);
            climbMessage = "Ready to descend Pivot Arms?";
            SmartDashboard.putString("Climb", climbMessage);
        } else if (m_climbValue == 4) { // Descend Pivot Arms- Should be on latches
            climbMessage = "Descending Pivot Arms";
            SmartDashboard.putString("ClimbArms", climbMessage);
            m_climbPID.setReference(Constants.climbDescendDistance, ControlType.kPosition);
            climbMessage = "Ready to raise Pivot Arms?";
            SmartDashboard.putString("Climb", climbMessage);
        } else if (m_climbValue == 5) { // Piston retracts, extends climb, piston extends, then climb extends again
            pistonRetract();
            m_climbPiston.set(DoubleSolenoid.Value.kReverse);
            climbMessage = "Raising Pivot Arms";
            SmartDashboard.putString("ClimbArms", climbMessage);
            m_climbPID.setReference(Constants.climbDistance2, ControlType.kPosition);
            pistonRelease();
            m_climbPiston.set(DoubleSolenoid.Value.kForward);
            m_climbPID.setReference(Constants.climbDistance3, ControlType.kPosition);
            climbMessage = "Ready to descend Pivot Arms?";
            SmartDashboard.putString("Climb", climbMessage);
        } else if (m_climbValue == 6) { // Descend Pivot Arms- Should be on latches - finish
            climbMessage = "Descending Pivot Arms";
            SmartDashboard.putString("ClimbArms", climbMessage);
            m_climbPID.setReference(Constants.climbDescendDistance, ControlType.kPosition);
        } else { // Descend default distance
            climbMessage = "Descending Pivot Arms";
            SmartDashboard.putString("ClimbArms", climbMessage);
            m_climbPID.setReference(Constants.climbDescendDistance, ControlType.kPosition);
            pistonRelease();
        }
    }

    public boolean isClimbAtTop() {
        // Returns the state of the upper limit switch
        boolean isClimbAtTop;
        m_climbEncoder.getPosition();
        if (m_climbEncoder.getPosition() >= Constants.CLIMB_MAX_OUTPUT) {
            isClimbAtTop = true;
        } else {
            isClimbAtTop = false;
        }
        return isClimbAtTop;
    }

    public boolean isClimbAtBottom() { // Might have to switch true/false because of magnetic limit switch
        // Returns the state of the lower limit switch
        boolean isClimbAtBottom;
        if (m_lowerClimbLimitSwitch.get()) {
            isClimbAtBottom = false;
        } else {
            isClimbAtBottom = true;
        }
        return isClimbAtBottom;
    }
}