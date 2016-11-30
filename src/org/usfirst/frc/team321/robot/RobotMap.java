package org.usfirst.frc.team321.robot;

/**
* The RobotMap is a mapping from the ports sensors and actuators are wired into
* to a variable name. This provides flexibility changing wiring, makes checking
* the wiring easier and significantly reduces the number of magic numbers
* floating around.
*/

public class RobotMap {
	
	//Motor ports
	public static final int LEFT_FRONT_MOTOR = 0;
	public static final int LEFT_MIDDLE_MOTOR = 1;
	public static final int LEFT_BACK_MOTOR = 2;
	
	public static final int RIGHT_FRONT_MOTOR = 3;
	public static final int RIGHT_MIDDLE_MOTOR = 4;
	public static final int RIGHT_BACK_MOTOR = 5;
	
	//Shooter ports
	public static final int SHOOTER = 6;
	
	//Intake port
	public static final int INTAKE_MOTOR = 8;
	
	//Encoder ports
	public static final int LEFT_ENCODER_A = 0;
	public static final int LEFT_ENCODER_B = 1;
	
	public static final int RIGHT_ENCODER_A = 2;
	public static final int RIGHT_ENCODER_B = 3;
}
