package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.GyroSensor;
import com.qualcomm.robotcore.hardware.Servo;

import java.sql.Time;
import java.util.Timer;

public class Robot {

    /*
        For auto: Mechs: Elevator, Hook, release marker
     */

    /*
        Intake: Arm thats got two parts that are connected side to side
        that extend outwards that goes up from ground 0 to 180
        inside each tube we have a servo
        each servo is attached to what basically is a wall that can block intake

     */

    private double NUM_TICKS = 500;
    private double CIRCUMFERENCE = 6.0 * Math.PI;

    public DcMotor leftBack;
    public DcMotor leftFront;
    public DcMotor rightBack;
    public DcMotor rightFront;

    public ColorSensor cSensor;

    public DcMotor intake;

    public DcMotor arm;

    public DcMotor climber;

    public GyroSensor gyro;

    public Servo hook;


    public void initialize(OpMode opMode) {
        leftBack = opMode.hardwareMap.dcMotor.get("leftBack");
        leftFront = opMode.hardwareMap.dcMotor.get("leftFront");
        rightBack = opMode.hardwareMap.dcMotor.get("rightBack");
        rightFront = opMode.hardwareMap.dcMotor.get("rightFront");

        cSensor = opMode.hardwareMap.colorSensor.get("cSensor");

        intake = opMode.hardwareMap.dcMotor.get("intakeArm");

        climber = opMode.hardwareMap.dcMotor.get("climber");

        gyro = opMode.hardwareMap.gyroSensor.get("gyro");

        arm = opMode.hardwareMap.dcMotor.get("arm");

        hook = opMode.hardwareMap.servo.get("hook");
    }

    public void encoderDrive(double inches, LinearOpMode opMode) {
        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        double target = (inches / CIRCUMFERENCE) * NUM_TICKS;

        leftFront.setTargetPosition((int) target);
        leftBack.setTargetPosition((int) target);
        rightFront.setTargetPosition((int) target);
        rightBack.setTargetPosition((int) target);

        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftBack.setPower(.25);
        leftFront.setPower(.25);
        rightBack.setPower(.25);
        rightFront.setPower(.25);

        while ((leftFront.isBusy() || leftBack.isBusy() || rightBack.isBusy() || rightFront.isBusy()) && opMode.opModeIsActive())
            ;

        leftBack.setPower(0);
        leftFront.setPower(0);
        rightBack.setPower(0);
        rightFront.setPower(0);

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void gyroTurn(int degrees) {
        degrees = degrees % 360;
        gyro.calibrate();
        //waits for gyro to finish calibrating
        while (gyro.isCalibrating()) ;
        if (degrees <= 180) {
            while (gyro.getHeading() < degrees + 2 && gyro.getHeading() > degrees - 2) {
                leftFront.setPower(0.25);
                leftBack.setPower(0.25);

                rightFront.setPower(-0.25);
                rightBack.setPower(-0.25);
            }
        } else {
            while (gyro.getHeading() < degrees + 2 && gyro.getHeading() > degrees - 2) {
                leftFront.setPower(-0.25);
                leftBack.setPower(-0.25);

                rightFront.setPower(0.25);
                rightBack.setPower(0.25);
            }
        }

    }


    public void runIntake(double power, double time) {
        intake.setPower(power);
        double tiempo = System.currentTimeMillis();
        while (System.currentTimeMillis() - tiempo < time * 1000) ;
        intake.setPower(0);
    }
    /*
    public void climberMove(double dPR, double max) {
        double dist =
    }
*/


}
