package racingDrivers.util;

/*
 * @author Munjal Shah
 */

public class MyLogger {

//    DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
//    DEBUG_VALUE=3 [Print to stdout everytime the state is changed]
//    DEBUG_VALUE=2 [Print to stdout at end of program]
//    DEBUG_VALUE=1 [Print to output at end of program]
//    DEBUG_VALUE=0 [No output should be printed from the application to stdout. It is ok to write to the output file though" ]
    
    public static enum DebugLevel {
        RELEASE,
        FROM_RESULTS,
        IN_RESULTS,
        IN_RUN,
        CONSTRUCTOR
    };

    private static DebugLevel debugLevel;

    public static void setDebugValue(int levelIn) {
        switch (levelIn) {
            case 4:
                debugLevel = DebugLevel.CONSTRUCTOR;
                break;

            case 3:
                debugLevel = DebugLevel.IN_RUN;
                break;

            case 2:
                debugLevel = DebugLevel.IN_RESULTS;
                break;

            case 1:
                debugLevel = DebugLevel.FROM_RESULTS;
                break;

            case 0:
                debugLevel = DebugLevel.RELEASE;
                break;
        }
    }

    public static void setDebugValue(DebugLevel levelIn) {
        debugLevel = levelIn;
    }

    public static void writeMessage(String message, DebugLevel levelIn) {
        if (levelIn == debugLevel) {
            System.out.println(message);
        }
    }

    public String toString() {
        return "Debug Level is " + debugLevel;
    }
}