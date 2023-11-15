package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Wheels;

public class Forward extends CommandBase
{
    public Forward()
{
    this.addRequirements (Robot.wheels);
}

public void execute()
{
    if(Robot.wheels.getWheelSwitch() == false)
    {
        Robot.wheels.setLeftWheelMotorState(Wheels.LeftWheelMoterState.ON);
        Robot.wheels.setRightWheelMotorState(Wheels.RightWheelMoterState.ON);
    }
    else
    {
        Robot.wheels.setLeftWheelMotorState(Wheels.LeftWheelMoterState.OFF);
        Robot.wheels.setRightWheelMotorState(Wheels.RightWheelMoterState.OFF);
    }
}
public void end(boolean interupted)
{
    Robot.wheels.setLeftWheelMotorState(Wheels.LeftWheelMoterState.OFF);
    Robot.wheels.setRightWheelMotorState(Wheels.RightWheelMoterState.OFF);
}
}
