package org.firstinspires.ftc.teamcode.util

import dev.nextftc.hardware.actuators.NextServo
import kotlin.math.abs

class CachedServo(
    private val servo: NextServo,
    private var cachingTolerance: Double = 0.001,
) {
    private var cachedPosition = Double.NaN

    fun setPosition(position: Double) {
        val corrected = position.coerceIn(-1.0..1.0)
        synchronized(this) {
            if (abs(corrected - cachedPosition) >= cachingTolerance || (corrected <= 0.0 && !(cachedPosition <= 0.0)) || (corrected >= 1.0 && !(cachedPosition >= 1.0)) || cachedPosition.isNaN()) {
                cachedPosition = corrected
                servo.position = corrected
            }
        }
    }
}