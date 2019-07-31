package racingDrivers.race;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import racingDrivers.driverStates.Drivers;
import racingDrivers.util.FileProcessor;

/*
 * @author Munjal Shah
 */
public class RaceContext {

    private static double leadingFormula;
    private static double holdingFormula;
    private static double losingFormula;

    public RaceContext(int drivers) {
        DriverContext obj = DriverContext.getInstance();
        obj.init(drivers);

        leadingFormula = 0.3 * (double) drivers;
        holdingFormula = new Double(Math.round(leadingFormula));
        losingFormula = new Double(Math.round(0.7 * (double) drivers));
    }

    public void setDriverDistance(String distance) {
        DriverContext obj = DriverContext.getInstance();
        obj.setDriverDistances(distance);
    }

    public void processData(List<String> distanceList) {
        for (String distances : distanceList) {
            setDriverDistance(distances);
            letsRace();
        }
    }

    /**
     * Logic of setting state
     */
    public void letsRace() {
        DriverContext driverContext = DriverContext.getInstance();
        List<Drivers> leadingDrivers = new LinkedList<>();
        List<Drivers> holdingOnDrivers = new LinkedList<>();
        List<Drivers> losingDrivers = new LinkedList<>();

        List<List<Drivers>> driversByPosition = driverContext.getDriverPositions();
        int position = 1;
        for (List<Drivers> driversList : driversByPosition) {
            for (Drivers drivers : driversList) {
                Positions driverPosition = findDriverPosition(position);
                if (Positions.LEADING == driverPosition) {
                    leadingDrivers.add(drivers);
                } else if (Positions.HOLDING_ON == driverPosition) {
                    holdingOnDrivers.add(drivers);
                } else if (Positions.LOSING == driverPosition) {
                    losingDrivers.add(drivers);
                }
            }
            position++;
        }
        driverContext.setDriverState(leadingDrivers, holdingOnDrivers, losingDrivers);
        //print output in file
        String content = driverContext.getDriversStates();
        new FileProcessor().writeToFile(content);
    }

    /**
     * Finds position of driver for
     * Leading, Holding_on and Losing
     * @param position
     * @return 
     */
    private Positions findDriverPosition(int position) {

        if (position < leadingFormula) {
            return Positions.LEADING;
        } else if (holdingFormula <= position && position < losingFormula) {
            return Positions.HOLDING_ON;
        } else if (position >= losingFormula) {
            return Positions.LOSING;
        }
        return null;
    }

}

enum Positions {

    LEADING, HOLDING_ON, LOSING
}
