package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.GyroSensor;

public class Auto extends LinearOpMode {

    GyroSensor gyro;

    public void runOpMode()
    {
        gyro.calibrate();
        while(gyro.isCalibrating());
        gyro.getHeading();
    }

}
