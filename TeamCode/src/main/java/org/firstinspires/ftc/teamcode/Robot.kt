package org.firstinspires.ftc.teamcode

import dev.nextftc.robot.NextRobot
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain
import org.firstinspires.ftc.teamcode.subsystems.Intake
import dev.nextftc.robot.Mechanism

class Robot : NextRobot {
    val intake = Intake()
    val drivetrain = Drivetrain()

    override val mechanisms: Set<Mechanism>
        get() = setOf(intake, drivetrain)
}