package org.firstinspires.ftc.teamcode.util

import dev.nextftc.hardware.actuators.NextMotor
import kotlin.math.abs

// https://github.com/Dairy-Foundation/CachingHardware/blob/master/CachingHardware/src/main/kotlin/dev/frozenmilk/dairy/cachinghardware/CachingDcMotor.kt
// ^ original but doesn't support nextmotor so had to port it
class CachedMotor(
    private val motor: NextMotor,
    private var cachingTolerance: Double = 0.005
) {
    private var cachedThrottle = Double.NaN

    fun setThrottle(throttle: Double) {
        val corrected = throttle.coerceIn(-1.0..1.0)
        if (abs(corrected - cachedThrottle) >= cachingTolerance || (corrected == 0.0 && cachedThrottle != 0.0) || (corrected >= 1.0 && !(cachedThrottle >= 1.0)) || (corrected <= -1.0 && !(cachedThrottle <= -1.0)) || cachedThrottle.isNaN()) {
            cachedThrottle = corrected
            motor.throttle = corrected
        }
    }
}