/*package org.firstinspires.ftc.teamcode.mechanisms

import dev.nextftc.hardware.actuators.NextMotor
import dev.nextftc.robot.Mechanism
import com.bylazar.configurables.annotations.Configurable
import dev.nextftc.units.radians
import kotlin.math.PI

@Configurable
class Slides : Mechanism {
    private val anglePerTick = (2 * PI / 537.7).radians
    val kP = 0.0
    val kI = 0.0
    val kD = 0.0
    val kG = 0.0
    val midtick = 1000.0
    val uptick = 2000.0
    val slides = NextMotor("slides").apply {
        positionConstants.kP = kP
        positionConstants.kI = kI
        positionConstants.kD = kD
        positionConstants.kG = kG
    }

    fun ticksToAngle(ticks: Double) = anglePerTick.times(ticks)

    val down = instant { slides.setPositionSetpoint(ticksToAngle(0.0)) }
    val mid = instant { slides.setPositionSetpoint(ticksToAngle(midtick)) }
    val up = instant { slides.setPositionSetpoint(ticksToAngle(uptick)) }
}*/