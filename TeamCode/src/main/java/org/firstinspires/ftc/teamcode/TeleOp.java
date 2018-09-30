package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class TeleOp extends OpMode {

    Robot robot = new Robot();



    public void init()
    {
        robot.initialize(this);
    }

    public void loop()
    {
        double ly = -gamepad1.left_stick_y;
        double ry = -gamepad1.right_stick_y;
        robot.leftBack.setPower(ly);
        robot.leftFront.setPower(ly);

        robot.rightBack.setPower(ry);
        robot.rightFront.setPower(ry);


    }
}
