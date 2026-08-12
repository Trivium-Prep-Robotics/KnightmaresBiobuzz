package org.firstinspires.ftc.teamcode.mechanisms

import dev.nextftc.hardware.actuators.NextMotor
import dev.nextftc.robot.Mechanism

class Intake : Mechanism {
    val intake = NextMotor("intake")

    val startIntake = instant { intake.throttle = 1.0 }
    val stopIntake = instant { intake.throttle = 0.0 }
    val reverseIntake = instant { intake.throttle = -1.0 }
}