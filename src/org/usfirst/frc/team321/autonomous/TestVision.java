package org.usfirst.frc.team321.autonomous;

import java.io.IOException;

import org.usfirst.frc.team321.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TestVision extends Command {

    public TestVision() {
        // Use requires() here to declare subsystem dependencies
    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	try {
			Process p = Runtime.getRuntime().exec("python3 /FRC_Vision/vision.py");
			p.waitFor();
			SmartDashboard.putNumber("Value!", p.waitFor());
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
    	
    	//Schrodinger's SmartDashboard. 
    	//Number won't update until you try to fetch it
    	SmartDashboard.putNumber("please1", SmartDashboard.getNumber("please8"));
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
