package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.DefaultDrive;
import org.firstinspires.ftc.teamcode.DriveSubsystem;

@TeleOp(name = "Just Drive")
public class JustDrive extends CommandOpMode {
    private GamepadEx driver;
    private DriveSubsystem drive;
    private DefaultDrive driveCommand;

    @Override
    public void initialize() {

        driver = new GamepadEx(gamepad1);
        GamepadEx codriver = new GamepadEx(gamepad2);
        drive = new DriveSubsystem(hardwareMap, "leftBack", "rightBack", "leftFront", "rightFront",
                new boolean[] {false, false, false, false});
        driveCommand = new DefaultDrive(drive,
                driver::getLeftX,
                driver::getLeftY,
                driver::getRightX,
                ()-> driver.getButton(GamepadKeys.Button.LEFT_BUMPER),
                ()-> driver.getButton(GamepadKeys.Button.RIGHT_BUMPER)

        );
        register(drive);
        drive.setDefaultCommand(driveCommand);

    }
}