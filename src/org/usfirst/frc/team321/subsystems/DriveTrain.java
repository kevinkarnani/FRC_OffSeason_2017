package org.usfirst.frc.team321.subsystems;
 
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

import org.usfirst.frc.team321.robot.RobotMap;
import org.usfirst.frc.team321.utilities.MathUtil;

import edu.wpi.first.wpilibj.Encoder;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public SpeedController leftFront, leftMiddle, leftBack, rightFront, rightMiddle, rightBack;
	public Encoder leftEncoder, rightEncoder;
	
	private static double MAX_POWER = 1.0;
	private static double MIN_POWER = -1.0;
	private static double kP = 0.0,
	                      kI = 0.0,
	                      kD = 0.0;
	
    public DriveTrain(){
    	 
        super(“Drive Train”);
 
            leftFront = new Talon(RobotMap.LEFT_FRONT_MOTOR);
            leftMiddle = new Talon(RobotMap.LEFT_MIDDLE_MOTOR);
            leftBack = new Talon(RobotMap.LEFT_BACK_MOTOR);
            
            rightFront = new Talon(RobotMap.RIGHT_FRONT_MOTOR);
            rightMiddle = new Talon(RobotMap.RIGHT_MIDDLE_MOTOR);
            rightBack = new Talon(RobotMap.RIGHT_BACK_MOTOR);
            
            leftEncoder = new Encoder(RobotMap.LEFT_ENCODER_ONE, RobotMap.LEFT_ENCODER_TWO);
            rightEncoder = new Encoder(RobotMap.RIGHT_ENCODER_ONE, RobotMap.RIGHT_ENCODER_TWO);
            
            leftEncoder.start();
            rightEncoder.start();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * Makes the robot move
     * @param leftPower Sets the power to the left side of the robot
     * @param rightPower Sets the power to the right side of the robot
     */
    public void setMotorPower(double leftPower, double rightPower){
    	leftFront.set(MathUtil.sqrt(MathUtil.range(leftPower, MIN_POWER, MAX_POWER)));
    	leftMiddle.set(MathUtil.sqrt(MathUtil.range(leftPower, MIN_POWER, MAX_POWER)));
    	leftBack.set(MathUtil.sqrt(MathUtil.range(leftPower, MIN_POWER, MAX_POWER)));
    	
    	//Inverts the right motor
    	rightFront.set(-MathUtil.sqrt(MathUtil.range(rightPower, MIN_POWER, MAX_POWER)));
    	rightMiddle.set(-MathUtil.sqrt(MathUtil.range(rightPower, MIN_POWER, MAX_POWER)));
    	rightBack.set(-MathUtil.sqrt(MathUtil.range(rightPower, MIN_POWER, MAX_POWER)));
    }

	public Encoder getLeftEncoderValue() {
		return leftEncoder.get();
	}

	public Encoder getRightEncoderValue() {
		return rightEncoder.get();
	}   
}
