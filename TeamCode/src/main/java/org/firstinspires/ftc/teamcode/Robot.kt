package org.firstinspires.ftc.teamcode

import com.qualcomm.hardware.lynx.LynxModule
import dev.nextftc.robot.NextRobot
import org.firstinspires.ftc.teamcode.mechanisms.Drivetrain
import org.firstinspires.ftc.teamcode.mechanisms.Intake
import dev.nextftc.robot.Mechanism
import com.seattlesolvers.solverslib.photon.PhotonCore

class Robot : NextRobot {
    val intake = Intake()
    val drivetrain = Drivetrain()
    //val slides = Slides()

    override val mechanisms: Set<Mechanism>
        get() = setOf(intake, drivetrain)

    override fun periodic() {
        PhotonCore.CONTROL_HUB.bulkCachingMode = LynxModule.BulkCachingMode.MANUAL
        PhotonCore.EXPANSION_HUB.bulkCachingMode = LynxModule.BulkCachingMode.MANUAL
        PhotonCore.experimental.setMaximumParallelCommands(8) // Can be adjusted based on user preference - but raising this number further can cause issues
        PhotonCore.enable()
    }
}