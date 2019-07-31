package racingDrivers.driverStates;

public class DriverStateFactory {

    public DriverStateI getDriverState(String driverState) {
        if (driverState == null) {
            return null;
        }

        if (driverState.equalsIgnoreCase("RECKLESS")) {
            return new RecklessState();
        } else if (driverState.equalsIgnoreCase("CONFIDENT")) {
            return new ConfidentState();
        } else if (driverState.equalsIgnoreCase("CALCULATIVE")) {
            return new CalculativeState();
        }
        return null;
    }
}
