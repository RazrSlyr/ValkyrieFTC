package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;

public class Auto extends LinearOpMode {

    DcMotor motor;

    final double NUM_OF_TICKS = 500;
    final double CIRCUMFERENCE = 10;
    public void runOpMode()
    {
        //sets up encoder movement
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setTargetPosition((int)(12 / CIRCUMFERENCE * NUM_OF_TICKS));
        motor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        motor.setPower(0.5);
        while (motor.isBusy());
        // sets the power to 0
        motor.setPower(0);
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

}
