package racingDrivers.race;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import racingDrivers.driverStates.Drivers;

public class DriverContext {

    private int drivers = 0;
    private List<Drivers> lDrivers = null;
    private static DriverContext driverContextObj = null;

    public int getDrivers() {
        return this.drivers;
    }

    private DriverContext() {

    }

    /**
     * Making singleton variable of DriverContext
     * @return 
     */
    public static DriverContext getInstance() {
        if (driverContextObj == null) {
            synchronized (DriverContext.class) {
                driverContextObj = new DriverContext();
            }
        }
        return driverContextObj;
    }

    /**
     * Adding drivers to linklist
     * @param drivers 
     */
    public void init(int drivers) {
        this.drivers = drivers;
        lDrivers = new LinkedList<>();
        for (int i = 0; i < this.drivers; i++) {
            lDrivers.add(new Drivers(i));
        }
    }

    /**
     * Setting driver distance
     * @param distance 
     */
    public void setDriverDistances(String distance) {
        String[] distanceArray = distance.split(" ");
        int index = 0;
        for (Drivers d : lDrivers) {
            d.setDistance(Double.parseDouble(distanceArray[index]));
            index++;
        }
    }

    /**
     * Getting list of driver position
     * @return 
     */
    public List<List<Drivers>> getDriverPositions() {
        List<List<Drivers>> driversListByPosition = new LinkedList<>();
        double[] distanceForDriver = new double[this.drivers];
        int index = 0;
        for (Drivers driver : lDrivers) {
            distanceForDriver[index] = driver.getDistance();
            index++;
        }

        int size = 0;
        while (size != lDrivers.size()) {
            List<Drivers> driversListAtPosition = getDriversByPosition(distanceForDriver);
            size += driversListAtPosition.size();
            driversListByPosition.add(driversListAtPosition);
        }
        return driversListByPosition;
    }

    /**
     * This method is used to get maxvalue
     * @param numbers
     * @return
     */
    private double getMaxValue(double[] numbers) {
        double maxValue = numbers[0];
        int i;
        for (i = 1; i < numbers.length; i++) {
            if (numbers[i] > maxValue) {
                maxValue = numbers[i];
            }
        }
        return maxValue;
    }

    /**
     * This method is used to get a list of index which has maximum value
     * @param array
     * @return
     */
    public List<Drivers> getDriversByPosition(double[] array) {
        List<Drivers> maxlist;
        maxlist = new ArrayList<>();
        double max_value = getMaxValue(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] == max_value && array[i] > -1.0) {
                maxlist.add(lDrivers.get(i));
                array[i] = -1.0;
            }
        }
        return maxlist;
    }

    /**
     * Setting driver state
     * @param leadingDrivers
     * @param holdingDrivers
     * @param losingDrivers 
     */
    public void setDriverState(List<Drivers> leadingDrivers, List<Drivers> holdingDrivers, List<Drivers> losingDrivers) {
        if (!leadingDrivers.isEmpty()) {
            for (Drivers drivers : leadingDrivers) {
                drivers.setDriverState((leadingDrivers.size() > 1) ? "RECKLESS" : "CONFIDENT");
            }
        }

        if (!holdingDrivers.isEmpty()) {
            for (Drivers drivers : holdingDrivers) {
                drivers.setDriverState((holdingDrivers.size() > 1) ? "RECKLESS" : "CALCULATIVE");
            }
        }

        if (!losingDrivers.isEmpty()) {
            for (Drivers drivers : losingDrivers) {
                drivers.setDriverState("RECKLESS");
            }
        }
    }

    /**
     * Getting driver state
     * @return 
     */
    public String getDriversStates() {
        String states = "";
        for (Drivers drivers : lDrivers) {
            states += drivers.getDriverState().getStateOfDriver() + " ";
        }
        return states.trim();

    }
}
