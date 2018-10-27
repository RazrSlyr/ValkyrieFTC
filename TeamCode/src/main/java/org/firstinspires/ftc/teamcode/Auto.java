package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;

public class Auto extends LinearOpMode {
    //this is a test
    Robot robot = new Robot();
    public void runOpMode() {
        //initialization
        robot.initialize(this);
        waitForStart();
        //movement
        while (opModeIsActive()) {
            //release hook
            robot.encoderMove(10, this);
            //drop our marker
            //park in the safe zone
            stop();
        }

    }

}
