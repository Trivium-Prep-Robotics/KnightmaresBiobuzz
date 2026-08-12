package org.firstinspires.ftc.teamcode.mechanisms

import dev.nextftc.hardware.actuators.NextMotor
import dev.nextftc.robot.Mechanism
import org.firstinspires.ftc.teamcode.util.CachedMotor

class Intake : Mechanism {
    val intakemotor = CachedMotor(NextMotor("intake"))

    val start = instant { intakemotor.setThrottle(1.0) }
    val stop = instant { intakemotor.setThrottle(0.0) }
    val reverse = instant { intakemotor.setThrottle(-1.0) }
}