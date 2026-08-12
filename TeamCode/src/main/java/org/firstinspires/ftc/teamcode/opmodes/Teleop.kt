package org.firstinspires.ftc.teamcode.opmodes

import dev.nextftc.robot.opmode.NextOpMode
import dev.nextftc.robot.opmode.NextTeleop
import dev.nextftc.robot.triggers.CommandGamepad
import dev.nextftc.robot.triggers.Trigger
import org.firstinspires.ftc.teamcode.Robot
import dev.nextftc.robot.opmode.BulkReadHook
@NextTeleop
class Teleop(robot: Robot) : NextOpMode(robot, BulkReadHook) {
    init {
        val driver = CommandGamepad(Trigger.defaultEventLoop, gamepad1)
        val operator = CommandGamepad(Trigger.defaultEventLoop, gamepad2)

        robot.drivetrain.drive(
            driver.leftStickY.value,
            driver.leftStickX.value,
            driver.rightStickX.value
        )

        operator.rightTrigger.isOver(0.2)
            .toggleOnTrue(robot.intake.start)
            .toggleOnFalse(robot.intake.stop)

        operator.y
            .toggleOnTrue(robot.intake.reverse)
            .toggleOnFalse(robot.intake.stop)
    }
}