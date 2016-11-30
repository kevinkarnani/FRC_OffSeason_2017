package org.usfirst.frc.team321.subsystems;

import org.usfirst.frc.team321.robot.RobotMap;
import org.usfirst.frc.team321.utilities.MathUtil;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

 /**
  * Intake class for the intake of the boulders. Uses enums as set values
  * to either intake at max power, outtake at max power, or just stall.
  */

public class Intake extends Subsystem {
	private SpeedController intakeMotor;
	
	/**
	 * Initializes Intake and calls the motor used for it from the RobotMap Class.
	 */
	
	public Intake(){
		intakeMotor = new Talon(RobotMap.INTAKE_MOTOR);
	}
	
	/**
	 * Creates enum values for the intake.
	 * Setting a positive value will intake the boulder into the robot.
	 * Setting a negative value will outtake the boulder from the robot.
	 * Setting a value of 0 will stall.
	 * These values are used in the Intake command.
	 */
	
	public enum IntakeValue {
		INTAKE(1.0), OUTTAKE(-1.0), STALL(0.0);
		
		private double value;
		
		private IntakeValue(double value){
			this.value = value;
		}
		
		public double getValue(){
			return value;
		}
	} 

	/**
	 * @param power Value for the intake must be within.
	 * the limit using MathUtil's clamp method, which
	 * creates a set range of which values can be used.
	 * Used in UseIntake command
	 */
	
	public void setIntakeLimit(double power){
		intakeMotor.set(MathUtil.clamp(power, -1.0, 1.0));
	}
	
    public void initDefaultCommand() {
    	//setDefaultCommand(new UseIntake());
    }
}
