package org.firstinspires.ftc.teamcode.mechanisms

import dev.nextftc.hardware.actuators.NextMotor
import dev.nextftc.robot.Mechanism
import org.firstinspires.ftc.teamcode.util.CachedMotor

class Intake : Mechanism {
    val intake = CachedMotor(NextMotor("intake"))

    val start = instant { intake.setThrottle(1.0) }
    val stop = instant { intake.setThrottle(0.0) }
    val reverse = instant { intake.setThrottle(-1.0) }
}