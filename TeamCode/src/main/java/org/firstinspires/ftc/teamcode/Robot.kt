package org.firstinspires.ftc.teamcode

import dev.nextftc.robot.NextRobot
import org.firstinspires.ftc.teamcode.mechanisms.Drivetrain
import org.firstinspires.ftc.teamcode.mechanisms.Intake
import dev.nextftc.robot.Mechanism

class Robot : NextRobot {
    val intake = Intake()
    val drivetrain = Drivetrain()
    //val slides = Slides()

    override val mechanisms: Set<Mechanism>
        get() = setOf(intake, drivetrain)
}