package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Wheels extends SubsystemBase {
    
    public enum LeftWheelMoterState
    {
        ON,
        OFF,
        REVERSED
    }

    public enum RightWheelMoterState
    {
        ON,
        OFF,
        REVERSED
    }

    public CANSparkMax LeftWheelMoter = new CANSparkMax (Constants.Wheels.leftWheelMoter, MotorType.kBrushless);
    public CANSparkMax RightWheelMoter = new CANSparkMax (Constants.Wheels.rightWheelMoter, MotorType.kBrushless);

    public DigitalInput WheelLimitSwitch = new DigitalInput (Constants.DIO.WheelLimitSwitch);

    public LeftWheelMoterState leftWheelMoter = LeftWheelMoterState.OFF;
    public RightWheelMoterState rightWheelMoter = RightWheelMoterState.OFF;

    public Wheels ()
    {

        this.LeftWheelMoter.setIdleMode(IdleMode.kBrake);
        this.RightWheelMoter.setIdleMode(IdleMode.kBrake);

        this.LeftWheelMoter.setSmartCurrentLimit(40);
        this.RightWheelMoter.setSmartCurrentLimit(40);
    }

    public void setLeftWheelMotorState(LeftWheelMoterState state)
    {
        this.leftWheelMoter = state;

        switch(state)
        {
            case ON:

                this.LeftWheelMoter.set(Constants.Wheels.WheelForwardSpeed);
                break;
            case OFF:
                this.LeftWheelMoter.set(0.0);
                break;
            case REVERSED:
                this.LeftWheelMoter.set(Constants.Wheels.WheelBackwardsSpeed);
                break;
                default:
                    this.setLeftWheelMotorState(LeftWheelMoterState.OFF);
        }
    }
    public void setRightWheelMotorState(RightWheelMoterState state)
    {
        this.rightWheelMoter = state;

        switch(state)
        {
            case ON:

                this.RightWheelMoter.set(Constants.Wheels.WheelForwardSpeed);
                break;
            case OFF:
                this.RightWheelMoter.set(0.0);
                break;
            case REVERSED:
                this.RightWheelMoter.set(Constants.Wheels.WheelBackwardsSpeed);
                break;

                default:
                    this.setRightWheelMotorState(RightWheelMoterState.OFF);
        }
    }

    public double getLeftWheelMotorPosition()
    {
        return this.LeftWheelMoter.getEncoder().getPosition();
    }

     public double getRightWheelMotorPosition()
    {
        return this.RightWheelMoter.getEncoder().getPosition();
    }

    public boolean getWheelSwitch()
    {
        return this.WheelLimitSwitch.get();
    }



}
