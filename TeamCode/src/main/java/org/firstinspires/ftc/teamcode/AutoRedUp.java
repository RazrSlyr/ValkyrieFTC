package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class AutoRedUp extends LinearOpMode {
    Robot robot = new Robot();
    public void runOpMode() {
        robot.initialize(this);
        waitForStart();
        while (opModeIsActive()) {
            robot.drop();
            double distance = Math.pow(2, 0.5) * 3 / 2;
            robot.encoderDrive(distance, this, 0.125);
            if(robot.seesBlock()) {
                robot.encoderDrive(distance, this, 0.125);
            } else {
                robot.encoderTurn(-90, 0.125, this);

            }
        }
    }
}
