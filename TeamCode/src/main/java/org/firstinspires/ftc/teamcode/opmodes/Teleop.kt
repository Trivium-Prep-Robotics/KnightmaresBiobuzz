package org.firstinspires.ftc.teamcode.opmodes

import com.qualcomm.hardware.lynx.LynxModule
import dev.nextftc.robot.opmode.BulkReadHook
import dev.nextftc.robot.opmode.NextOpMode
import dev.nextftc.robot.opmode.NextTeleop
import dev.nextftc.robot.triggers.CommandGamepad
import dev.nextftc.robot.triggers.Trigger
import org.firstinspires.ftc.teamcode.Robot

@NextTeleop
class Teleop(robot: Robot) : NextOpMode(robot, BulkReadHook) {
    var controlhub: LynxModule? = null
    var expansionhub: LynxModule? = null
    init {
        val driver = CommandGamepad(Trigger.defaultEventLoop, gamepad1)
        val operator = CommandGamepad(Trigger.defaultEventLoop, gamepad2)

        controlhub = hardwareMap.get(LynxModule::class.java, "Control Hub")
        controlhub!!.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL)
        controlhub!!.clearBulkCache()
        expansionhub = hardwareMap.get(LynxModule::class.java, "Expansion Hub 2")
        expansionhub!!.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL)
        expansionhub!!.clearBulkCache()

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