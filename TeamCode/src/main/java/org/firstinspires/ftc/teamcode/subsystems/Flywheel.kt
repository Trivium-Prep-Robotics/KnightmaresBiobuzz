package org.firstinspires.ftc.teamcode.subsystems

import dev.nextftc.hardware.actuators.NextMotor
import dev.nextftc.robot.Mechanism
import com.bylazar.configurables.annotations.Configurable
import dev.nextftc.units.Degrees
import dev.nextftc.units.measuretypes.AngularVelocity

@Configurable
class Flywheel : Mechanism {
    val kP = 0.0
    val kI = 0.0
    val kD = 0.0
    val kV = 0.0
    val kS = 0.0


    val flywheel = NextMotor("flywheel").apply {
        velocityConstants.kP = kP
        velocityConstants.kI = kI
        velocityConstants.kD = kD
        velocityConstants.kV = kV
        velocityConstants.kS = kS
    }
    val off = instant { flywheel.setVelocitySetpoint(0.0) }
}