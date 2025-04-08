package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandBase;


import org.firstinspires.ftc.teamcode.DriveSubsystem;

import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

public class DefaultDrive extends CommandBase {
    private final DriveSubsystem drive;

    private final DoubleSupplier strafeSpeed;
    private final DoubleSupplier forwardSpeed;
    private final DoubleSupplier turnSpeed;

    private final BooleanSupplier leftBumper;
    private final BooleanSupplier rightBumper;

    public DefaultDrive(DriveSubsystem subsystem, DoubleSupplier strafe, DoubleSupplier forward, DoubleSupplier turn, BooleanSupplier left, BooleanSupplier right) {
        drive = subsystem;
        strafeSpeed = strafe;
        forwardSpeed = forward;
        turnSpeed = turn;
        leftBumper = left;
        rightBumper = right;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        double strafe = strafeSpeed.getAsDouble();
        double forward = forwardSpeed.getAsDouble();
        double turn = turnSpeed.getAsDouble();
        if (leftBumper.getAsBoolean() || rightBumper.getAsBoolean()) {
            strafe *= 0.7;
            forward *= 0.7;
            turn *= 0.7;
        }
        drive.drive(strafe, forward, -turn);
    }

}
