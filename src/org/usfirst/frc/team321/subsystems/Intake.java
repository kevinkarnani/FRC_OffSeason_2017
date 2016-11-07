package org.usfirst.frc.team321.subsystems;

import org.usfirst.frc.team321.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *Intake class for the intake of the boulders
 */
public class Intake extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private SpeedController intakeMotor;
	
	
	/**
	 * @author GalacticArc
	 * Initializes Intake and calls the motor used for it from the RobotMap Class
	 */
	
	public Intake(){
		
		intakeMotor = new Talon(RobotMap.INTAKE_MOTOR);
		
	}
	
	/**
	 * @author linw5
	 *Created enumerations values for the intake 
	 *Intake into the robot, outtake into the robot, and stall
	 *Checks if the absolute value of the power is above one or not
	 *Motor power set to 0.8 as a precaution
	 *Preset MIN and MAX values for motors for future code
	 */
	
	public enum IntakeMovement {
		
		
		INTAKE(0.8), OUTTAKE(-0.8), STALL(0.0);
		//MAX_INTAKE(1.0), MIN_OUTTAKE(0.0)
		
		private double movement;
		
		private IntakeMovement(double movement){
			this.movement = movement;
		}
		
		public double getMovement(){
			return movement;
		}
	} 
	/**
	 * @param power
	 * Power of the intake motor cannot exceed one
	 * If it does, it sets it back to power
	 */
	public void setMovementLimit(double power) {
		if(Math.abs(power) <= 1){
			intakeMotor.set(power); 
		}
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
}
