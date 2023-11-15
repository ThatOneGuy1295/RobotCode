package frc.robot;

public final class Constants {
    
    public static class CANIds 
    {
        public static final int leftWheelMoter = 1;
        public static final int rightWheelMoter = 2;
    }

    public static class DIO 
    {
        public static int WheelLimitSwitch = 1;
    }

    public static class Wheels
    {
        public static int leftWheelMoter = CANIds.leftWheelMoter;
        public static int rightWheelMoter = CANIds.rightWheelMoter;

        public static double WheelForwardSpeed = 1;
        public static double WheelBackwardsSpeed = -1;
    }


}



