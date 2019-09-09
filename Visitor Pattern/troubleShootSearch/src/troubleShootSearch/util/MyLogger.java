package troubleShootSearch.util;

/*
 * @author Munjal Shah
 */
public class MyLogger {

    /*DEBUG_VALUE=7 [Printing message from SemanticMatch class]
     DEBUG_VALUE=6 [Printing message from NaiveStemmingMatch class]
     DEBUG_VALUE=5 [Printing message from ExcatMatch class]
     DEBUG_VALUE=4 [Printing message from DSeaGate class]
     DEBUG_VALUE=3 [Printing message from Results class]
     DEBUG_VALUE=2 [Printing message from FileProcessor class]
     DEBUG_VALUE=1 [Printing message from Driver class]*/
    private static DebugLevel debugLevel;

    public static enum DebugLevel {

        Driver,
        FileProcessor,
        Results,
        DSeaGate,
        ExcatMatch,
        NaiveStemmingMatch,
        SemanticMatch,
        NONE
    };

    public MyLogger() {
        debugLevel = DebugLevel.FileProcessor;
    }

    public static void debugValue(int i) {
        switch (i) {
            case 1:
                debugLevel = DebugLevel.Driver;
                break;

            case 2:
                debugLevel = DebugLevel.FileProcessor;
                break;

            case 3:
                debugLevel = DebugLevel.Results;
                break;

            case 4:
                debugLevel = DebugLevel.DSeaGate;
                break;

            case 5:
                debugLevel = DebugLevel.ExcatMatch;
                break;

            case 6:
                debugLevel = DebugLevel.NaiveStemmingMatch;
                break;

            case 7:
                debugLevel = DebugLevel.SemanticMatch;
                break;

            default:
                debugLevel = DebugLevel.NONE;
                break;
        }
    }

    public static void debugValue(DebugLevel debugLevel) {
        MyLogger.debugLevel = debugLevel;
    }

    /**
     * This method writes message to console
     *
     * @param message
     * @param debugLevel
     */
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
