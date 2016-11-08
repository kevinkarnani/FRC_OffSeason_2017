package org.usfirst.frc.team321.subsystems;

import org.usfirst.frc.team321.robot.RobotMap;
import org.usfirst.frc.team321.utilities.MathUtil;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *Shooter class for the shooter of the robot which takes boulders
 *from the shooter motor and shoots it. It incorporates PID and commands
 *to guide it towards the high goal.
 */
public class Shooter extends Subsystem {
	private SpeedController shooter;
	
/**
 * Retrieves the shooter motor from the RobotMap
 */
	public Shooter(){
		shooter = new Talon(RobotMap.SHOOTER);
		
	}

	/**
	 * @param power value of the motor being checked
	 * Used in UseShooter command
	 */
	public void setShooterLimit(double power){
		shooter.set(MathUtil.clamp(power, -1.0, 1.0));
	}

    public void initDefaultCommand() {
    	//setDefaultCommand(new UseShooter());
    }
}
