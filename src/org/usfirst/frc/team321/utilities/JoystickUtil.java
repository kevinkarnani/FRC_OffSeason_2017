package org.usfirst.frc.team321.utilities;

import org.usfirst.frc.team321.robot.OI;

public class JoystickUtil {
	public final static double MIN_JOY_VALUE = 0.10;
	
	/**
	 * Gets the x value from the left joystick on the driver controller
	 * 
	 * @return the left X value from the left joystick
	 */
	public static double getLeftXValue() {
		if (Math.abs(OI.driveStick.getRawAxis(0)) > MIN_JOY_VALUE) {
			return MathUtil.range(OI.driveStick.getRawAxis(0), -1.0, 1.0);
		} else {
			return 0;
		}
	}
	
	/**
	 * Gets the y value from the left joystick on the driver controller
	 * 
	 * <p>Note: The joystick normally returns a negative value on the top and
	 * a positive value on the bottom. The number is multiplied by negative one 
	 * so the y axis is flipped.
	 * 
	 * @return the left Y value from the left joystick
	 */
	public static double getLeftYValue() {
		if (Math.abs(OI.driveStick.getRawAxis(1)) > MIN_JOY_VALUE) {
			return MathUtil.range(-OI.driveStick.getRawAxis(1), -1.0, 1.0);
		} else {
			return 0;
		}
	}
	
	/**
	 * Gets the x value from the right joystick on the driver controller
	 * 
	 * @return the right x value from the right joystick
	 */
	public static double getRightXValue() {
		if (Math.abs(OI.driveStick.getRawAxis(2)) > MIN_JOY_VALUE) {
			return MathUtil.range(OI.driveStick.getRawAxis(2), -1.0, 1.0);
		} else {
			return 0;
		}
	}
	
	/**
	 * Gets the y value from the right joystick on the driver controller
	 * 
	 * <p>Note: The joystick normally returns a negative value on the top and
	 * a positive value on the bottom. The number is multiplied by negative one so 
	 * the y axis is flipped.
	 * 
	 * @return the right Y value from the right joystick
	 */
	public static double getRightYValue() {
		if (Math.abs(OI.driveStick.getRawAxis(3)) > MIN_JOY_VALUE) {
			return MathUtil.range(-OI.driveStick.getRawAxis(3), -1.0, 1.0);
		} else {
			return 0;
		}
	}
	
	/**
	 * Gets the x value from the joystick on the manipulator controller
	 * 
	 * @return the x value from the manipulator joystick
	 */
	public static double getManiXValue() {
		if (Math.abs(OI.maniStick.getRawAxis(0)) > MIN_JOY_VALUE) {
			return MathUtil.range(OI.maniStick.getRawAxis(0), -1.0, 1.0);
		} else {
			return 0;
		}
	}
	
	/**
	 * Gets the y value from the joystick on the manipulator controller
	 * 
	 * <p>Note: The joystick normally returns a negative value on the top and
	 * a positive value on the bottom. The number is multiplied by negative one so 
	 * the y axis is flipped.
	 * 
	 * @return the Y value from the manipulator joystick
	 */
	public static double getManiYValue() {
		if (Math.abs(OI.maniStick.getRawAxis(1)) > MIN_JOY_VALUE) {
			return MathUtil.range(-OI.maniStick.getRawAxis(1), -1.0, 1.0);
		} else {
			return 0;
		}
	}
	
	/**
	 * Squares the x value on the left joystick
	 * 
	 * <p>When setting motor values, numbers do not correlate to their
	 * actual speed. The motor spins at the rate of a set number square
	 * rooted.
	 * 
	 * <p>For example, setting a motor speed to 0.5 does not make the
	 * motor spin at 50% power. Theoretically, it spins around 70% when 
	 * set in a value of 0.5. Squaring 0.5 gets 0.25. When 0.25 gets put
	 * into the motor, the motor spins at 50% power.
	 * 
	 * @return the x value on the left joystick squared
	 */
	public static double getLeftXNormalized() {
		return MathUtil.square(getLeftXValue());
	}
	
	/**
	 * Squares the y value on the left joystick
	 * 
	 * <p>When setting motor values, numbers do not correlate to their
	 * actual speed. The motor spins at the rate of a set number square
	 * rooted.
	 * 
	 * <p>For example, setting a motor speed to 0.5 does not make the
	 * motor spin at 50% power. Theoretically, it spins around 70% when 
	 * set in a value of 0.5. Squaring 0.5 gets 0.25. When 0.25 gets put
	 * into the motor, the motor spins at 50% power.
	 * 
	 * @return the y value on the left joystick squared
	 */
	public static double getLeftYNormalized() {
		return MathUtil.square(getLeftYValue());
	}
	
	/**
	 * Squares the x value on the right joystick
	 * 
	 * <p>When setting motor values, numbers do not correlate to their
	 * actual speed. The motor spins at the rate of a set number square
	 * rooted.
	 * 
	 * <p>For example, setting a motor speed to 0.5 does not make the
	 * motor spin at 50% power. Theoretically, it spins around 70% when 
	 * set in a value of 0.5. Squaring 0.5 gets 0.25. When 0.25 gets put
	 * into the motor, the motor spins at 50% power.
	 * 
	 * @return the x value on the right joystick squared
	 */
	public static double getRightXNormalized() {
		return MathUtil.square(getRightXValue());
	}
	
	/**
	 * Squares the y value on the right joystick
	 * 
	 * <p>When setting motor values, numbers do not correlate to their
	 * actual speed. The motor spins at the rate of a set number square
	 * rooted.
	 * 
	 * <p>For example, setting a motor speed to 0.5 does not make the
	 * motor spin at 50% power. Theoretically, it spins around 70% when 
	 * set in a value of 0.5. Squaring 0.5 gets 0.25. When 0.25 gets put
	 * into the motor, the motor spins at 50% power.
	 * 
	 * @return the y value on the right joystick squared
	 */
	public static double getRightYNormalized() {
		return MathUtil.square(getRightYValue());
	}
	
	/**
	 * Gives back the degrees of the left joystick on the drive controller
	 * 
	 * @return  the degree created by the left joystick
	 */
	public static double getLeftDegrees() {
		return 180 - Math.toDegrees(Math.atan2(-getLeftYValue(), -getLeftXValue()));
	}
	
	/**
	 * Gives back the degrees of the right joystick on the drive controller
	 * 
	 * @return  the degree created by the right joystick
	 */
	public static double getRightDegrees() {
		return 180 - Math.toDegrees(Math.atan2(-getRightYValue(), -getRightXValue()));
	}
	
	/**
	 * Gives back the degrees of the joystick on the manipulator controller
	 * 
	 * @return  the degree created by the manipulator joystick
	 */
	public static double getManiDegrees() {
		return 180 - Math.toDegrees(Math.atan2(-getManiYValue(), -getManiXValue()));
	}
}