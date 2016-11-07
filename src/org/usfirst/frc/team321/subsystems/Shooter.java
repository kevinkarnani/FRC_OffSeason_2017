package org.usfirst.frc.team321.subsystems;

import org.usfirst.frc.team321.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *Shooter class for the shooter of the robot
 */
public class Shooter extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private SpeedController roboShooter1, roboShooter2;

	

/**
 * Retrieves the motors used for the shooters from the RobotMap
 */
	
	public Shooter(){
		
		roboShooter1 = new Talon(RobotMap.LEFT_SHOOTER);
		roboShooter2 = new Talon(RobotMap.RIGHT_SHOOTER);
		
	}
	/**
	 * @param power
	 * Motor power cannot exceed 1, sets it less than one if it does
	 */
	public void shootingLimit(double power){
		
		if(Math.abs(power) <= 1){
			
			roboShooter1.set(power);
			roboShooter2.set(power);
		}
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
}
