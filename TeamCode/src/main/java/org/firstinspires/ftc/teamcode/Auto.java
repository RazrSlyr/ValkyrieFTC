package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;

public class Auto extends LinearOpMode {

    Robot robot = new Robot();


    public void runOpMode()
    {
        robot.initialize(this);
        waitForStart();
        while (opModeIsActive())
        {

        }
    }

}
