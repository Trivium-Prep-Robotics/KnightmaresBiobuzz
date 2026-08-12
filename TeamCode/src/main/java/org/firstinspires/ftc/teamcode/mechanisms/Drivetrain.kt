package org.firstinspires.ftc.teamcode.mechanisms

import dev.nextftc.hardware.actuators.NextMotor
import dev.nextftc.robot.Mechanism
import kotlin.math.abs
import kotlin.math.max

class Drivetrain : Mechanism {
    val lf = NextMotor("lf").apply { direction = NextMotor.Direction.REVERSE }
    val lb = NextMotor("lb").apply { direction = NextMotor.Direction.REVERSE }
    val rf = NextMotor("rf")
    val rb = NextMotor("rb")

    fun drive(x: Double, y: Double, rx: Double) = infinite {
        val denominator = max(abs(x) + abs(y) + abs(rx), 1.0)

        lf.throttle = ((y + x + rx).div(denominator))
        lb.throttle = ((y + x + rx).div(denominator))
        rf.throttle = ((y - x + rx).div(denominator))
        rb.throttle = ((y - x + rx).div(denominator))
    }
}