package org.usfirst.frc.team321.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

import org.usfirst.frc.team321.autonomous.TestVision;
import org.usfirst.frc.team321.robot.RobotMap;
import org.usfirst.frc.team321.utilities.MathUtil;

//import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SerialPort;

 /**
   * The DriveTrain class handles movement with the
   * drive base of the robot, which is a 6-wheel
   * west coast drive.
   */

public class DriveTrain extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public CANTalon leftFront, leftMiddle, leftBack, rightFront, rightMiddle, rightBack;
	public Encoder leftEncoder;
	public Encoder rightEncoder;
	// public AHRS navX;

	/**
	 * Circumference of the wheel in cm
	 */
	public final double wheelCircumference = 19.939 * Math.PI;

	/**
	 * How many encoder ticks to go 1 cm
	 */
	public final double ticksPerCm = 360 / wheelCircumference;

	private static final double MAX_POWER = 1.0;
	private static final double MIN_POWER = -1.0;
	static final double kP = 0, kI = 0, kD = 0;

	public DriveTrain() {

		super("Drive Train");

		leftFront = new CANTalon(RobotMap.LEFT_FRONT_MOTOR);
		leftMiddle = new CANTalon(RobotMap.LEFT_MIDDLE_MOTOR);
		leftBack = new CANTalon(RobotMap.LEFT_BACK_MOTOR);

		rightFront = new CANTalon(RobotMap.RIGHT_FRONT_MOTOR);
		rightMiddle = new CANTalon(RobotMap.RIGHT_MIDDLE_MOTOR);
		rightBack = new CANTalon(RobotMap.RIGHT_BACK_MOTOR);

		leftEncoder = new Encoder(RobotMap.LEFT_ENCODER_A, RobotMap.LEFT_ENCODER_B);
		rightEncoder = new Encoder(RobotMap.RIGHT_ENCODER_A, RobotMap.RIGHT_ENCODER_B);
		leftEncoder.setReverseDirection(true);
		/*
		 * navX = new AHRS(SerialPort.Port.kMXP); navX.reset();
		 * navX.resetDisplacement();
		 */
		leftEncoder.reset();
		rightEncoder.reset();
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		//CHANGE THIS LATER
		setDefaultCommand(new TestVision());
	}

	/**
	 * Sets power to the motor and makes the robot move.
	 *
	 * @param leftPower
	 *            Sets the power to the left side of the robot
	 * @param rightPower
	 *            Sets the power to the right side of the robot
	 */
	
	public void setMotorPower(double leftPower, double rightPower) {
		leftFront.set(normalizeMotorValue(leftPower, MIN_POWER, MAX_POWER));
		leftMiddle.set(normalizeMotorValue(leftPower, MIN_POWER, MAX_POWER));
		leftBack.set(normalizeMotorValue(leftPower, MIN_POWER, MAX_POWER));

		// Inverts the right motor
		rightFront.set(-normalizeMotorValue(rightPower, MIN_POWER, MAX_POWER));
		rightMiddle.set(-normalizeMotorValue(rightPower, MIN_POWER, MAX_POWER));
		rightBack.set(-normalizeMotorValue(rightPower, MIN_POWER, MAX_POWER));
	}

	public double getLeftEncoderValue() {
		return leftEncoder.getDistance();
	}

	public double getRightEncoderValue() {
		return rightEncoder.getDistance();
	}

	/**
	 * Returns a normalized value in between a range of numbers
	 * 
	 * @param power
	 *            The power the motor is set to.
	 * @param minPower
	 *            The minimum power -1.
	 * @param maxPower
	 *            The maximum power 1.
	 * @return
	 *            The power if within the the range.
	 */
	
	public double normalizeMotorValue(double power, double minPower, double maxPower) {
		return MathUtil.squareKeepSign(MathUtil.clamp(power, minPower, maxPower));
	}

	public void stopMotor() {
		leftFront.disableControl();
		leftMiddle.disableControl();
		leftBack.disableControl();

		rightFront.disableControl();
		rightMiddle.disableControl();
		rightBack.disableControl();
	}

	public void clearEncoder() {
		leftEncoder.reset();
		rightEncoder.reset();
	}

	/**
	 * Converts the robot movement in centimeters to encoder movement in degrees.
	 * 
	 * @param cm
	 * @param wheelCircumference
	 *            The circumference of the wheels.
	 * @return
	 *            The encoder movement in degrees.
	 */
	
	public double distanceToEncDegrees(double distance) {
		return (distance * 360) / (wheelCircumference);
	}

	/**
	 * Convert cm of robot movement to rotations by the encoder.
	 * 
	 * @param cm
	 * @param wheelCircumference
	 *            The circumference of the wheels.
	 * @return
	 *            The displacement of the encoder.
	 */
	
	public double encDistanceToDistance(double encDistance) {
		return (encDistance / 360) * wheelCircumference;
	}

	public double getLeftSpeedInRPM() {
		return (leftEncoder.getRate() / 360) * 60;
	}

	public double getRightSpeedInRPM() {
		return (rightEncoder.getRate() / 360) * 60;
	}
}
