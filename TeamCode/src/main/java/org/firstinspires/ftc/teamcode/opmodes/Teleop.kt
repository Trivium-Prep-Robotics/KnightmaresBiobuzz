package org.firstinspires.ftc.teamcode.opmodes

import com.pedropathing.ivy.commands.Commands
import dev.nextftc.robot.opmode.NextOpMode
import dev.nextftc.robot.opmode.NextTeleop
import dev.nextftc.robot.triggers.CommandGamepad
import dev.nextftc.robot.triggers.Trigger
import org.firstinspires.ftc.teamcode.Robot
import dev.nextftc.robot.opmode.BulkReadHook
import org.firstinspires.ftc.teamcode.Constants

@NextTeleop
class Teleop(robot: Robot) : NextOpMode(robot, BulkReadHook) {
    init {
        val driver = CommandGamepad(Trigger.defaultEventLoop, gamepad1)
        val operator = CommandGamepad(Trigger.defaultEventLoop, gamepad2)
        var slowmode = false

        if (!slowmode) {
            robot.drivetrain.drive(
                driver.leftStickY.value,
                driver.leftStickX.value,
                driver.rightStickX.value
            )
        } else {
            robot.drivetrain.drive(
                driver.leftStickY.value * Constants().slowdrivemulitpiler,
                driver.leftStickX.value * Constants().slowdrivemulitpiler,
                driver.rightStickX.value * Constants().slowdrivemulitpiler
            )
        }

        operator.rightTrigger.isOver(0.2)
            .toggleOnTrue(robot.intake.start)
            .toggleOnFalse(robot.intake.stop)

        operator.y
            .toggleOnTrue(robot.intake.reverse)
            .toggleOnFalse(robot.intake.stop)

        driver.rightBumper.toggleOnTrue(Commands.instant {slowmode = !slowmode})
        robot.clearCaches()
    }
}