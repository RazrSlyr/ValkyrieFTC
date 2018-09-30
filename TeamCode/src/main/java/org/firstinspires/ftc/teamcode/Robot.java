package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

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
    private double  CIRCUMFERENCE = 6.0 * Math.PI;

    public DcMotor leftBack;
    public DcMotor leftFront;
    public DcMotor rightBack;
    public DcMotor rightFront;

    public Servo silverGate;
    public Servo goldGate;

    public ColorSensor cSensor;

    public DcMotor intakeArm;

    public DcMotor climber;


    public void initialize(OpMode opMode)
    {
        leftBack = opMode.hardwareMap.dcMotor.get("leftBack");
        leftFront = opMode.hardwareMap.dcMotor.get("leftFront");

        rightBack = opMode.hardwareMap.dcMotor.get("rightBack");
        rightFront = opMode.hardwareMap.dcMotor.get("rightFront");

        silverGate = opMode.hardwareMap.servo.get("silverGate");
        goldGate = opMode.hardwareMap.servo.get("goldGate");

        cSensor = opMode.hardwareMap.colorSensor.get("cSensor");

        intakeArm = opMode.hardwareMap.dcMotor.get("intakeArm");

        climber = opMode.hardwareMap.dcMotor.get("climber");
    }











}
