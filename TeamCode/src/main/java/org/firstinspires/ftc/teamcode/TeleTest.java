package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="TeleOp", group="Tele")
public class TeleTest extends OpMode {

    Robot robot = new Robot();
    public void init() {

        robot.initialize(this);
    }

    public void loop() {

        //storing joystick

        //storing joystick values in vars
        double ly = -gamepad1.left_stick_y;
        double ry = -gamepad1.right_stick_y;


        //connecting left stick to the left motor
        robot.left.setPower(ly);

        //connecting right stick to the right motor
        robot.right.setPower(ry);


    }
}
