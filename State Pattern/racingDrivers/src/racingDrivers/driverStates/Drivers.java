package racingDrivers.driverStates;

public class Drivers {

    private int id;
    private double distance = 0;
    private DriverStateI driverState = null;

    public Drivers(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance += distance;
    }

    public DriverStateI getDriverState() {
        return driverState;
    }

    public void setDriverState(DriverStateI driverState) {
        this.driverState = driverState;
    }

    public void setDriverState(String driverState) {
        this.driverState = new DriverStateFactory().getDriverState(driverState);
    }
}
