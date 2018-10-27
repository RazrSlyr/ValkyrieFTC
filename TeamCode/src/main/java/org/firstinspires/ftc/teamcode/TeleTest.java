package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

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


        //connecting left stick to the left motors
        robot.leftBack.setPower(ly);
        robot.leftFront.setPower(ly);

        //connecting right stick to the left motors
        robot.rightBack.setPower(ry);
        robot.rightFront.setPower(ry);


    }
}
