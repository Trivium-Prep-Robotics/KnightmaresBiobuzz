package org.firstinspires.ftc.teamcode

import com.qualcomm.hardware.lynx.LynxModule
import dev.nextftc.robot.NextRobot
import org.firstinspires.ftc.teamcode.mechanisms.Drivetrain
import org.firstinspires.ftc.teamcode.mechanisms.Intake
import dev.nextftc.robot.Mechanism
//import com.seattlesolvers.solverslib.photon.PhotonCore

class Robot : NextRobot {
    val intake = Intake()
    val drivetrain = Drivetrain()
    //val slides = Slides()

    override val mechanisms: Set<Mechanism>
        get() = setOf(intake, drivetrain)
}