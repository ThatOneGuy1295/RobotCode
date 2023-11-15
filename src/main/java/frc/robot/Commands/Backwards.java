package frc.robot.Commands;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Wheels;

public class Backwards extends CommandBase {
    public Backwards()
    {
        this.addRequirements(Robot.wheels);
    }
   
    public void execute()
    {
        if(Robot.wheels.getLeftWheelMotorPosition() >= -10)
        {
            Robot.wheels.setLeftWheelMotorState(Wheels.LeftWheelMoterState.REVERSED);
            Robot.wheels.setRightWheelMotorState(Wheels.RightWheelMoterState.REVERSED);
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
