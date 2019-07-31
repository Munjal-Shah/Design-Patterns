package studentCourseBackup.util;

/*
 * @author Munjal Shah
 */
public class MyLogger {

    /*DEBUG_VALUE=6 [Prints value from Tree class]
     DEBUG_VALUE=5 [Prints value from Result class]
     DEBUG_VALUE=4 [Print value from FileProcessor class]
     DEBUG_VALUE=3 [Print value from Node class]
     DEBUG_VALUE=2 [Print value from Driver class]
     DEBUG_VALUE=1 [Print value from StudentCoursesBackup class]*/
    private static DebugLevel debugLevel;

    public static enum DebugLevel {

        StudentCoursesBackup,
        Driver,
        Node,
        FileProcessor,
        Results,
        Tree,
        NONE
    };

    public MyLogger() {
        debugLevel = DebugLevel.FileProcessor;
    }

    public static void debugValue(int i) {
        switch (i) {
            case 1:
                debugLevel = DebugLevel.StudentCoursesBackup;
                break;

            case 2:
                debugLevel = DebugLevel.Driver;
                break;

            case 3:
                debugLevel = DebugLevel.Node;
                break;

            case 4:
                debugLevel = DebugLevel.FileProcessor;
                break;

            case 5:
                debugLevel = DebugLevel.Results;
                break;

            case 6:
                debugLevel = DebugLevel.Tree;
                break;

            default:
                debugLevel = DebugLevel.NONE;
                break;
        }
    }

    public static void debugValue(DebugLevel debugLevel) {
        MyLogger.debugLevel = debugLevel;
    }

    public static void writeMessage(String message, DebugLevel debugLevel) {
        if (MyLogger.debugLevel == debugLevel) {
            Results results = new Results();
            results.writeToStdout(message);
        }
    }

    @Override
    public String toString() {
        return "The debug level has been set to the following " + debugLevel + " debug level.";
    }
}
