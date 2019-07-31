package racingDrivers.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import racingDrivers.race.RaceContext;

/*
 * @author Munjal Shah
 */
public class FileProcessor {

    private static File inputFile = null;
    private static File outputFile = null;

    public FileProcessor(String inputFileName, String outputFileName) {
        inputFile = new File(inputFileName);
        checkFileIsEmpty(outputFileName);
        outputFile = new File(outputFileName);
    }

    public FileProcessor() {

    }

    /**
     * This method reads line by line from file and stores in the list
     * @param fileName
     * @return
     */
    public void readLine(String fileName) {
        String line;
        List<String> distanceListForDriver = new LinkedList<>();
        RaceContext raceObj = null;
        try (FileReader fr = new FileReader(inputFile)) {
            try (BufferedReader br = new BufferedReader(fr)) {
                line = br.readLine();
                raceObj = new RaceContext(Integer.parseInt(line));

                while ((line = br.readLine()) != null) {
                    distanceListForDriver.add(line);
                }
                raceObj.processData(distanceListForDriver);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks if file is empty
     * @param filename 
     */
    public static void checkFileIsEmpty(String filename) {
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(filename);
            fout.write(("").getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fout != null) {
                    fout.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This method is used to write to file
     * @param fileName
     * @param content
     */
    public void writeToFile(String content) {

        FileWriter fw = null;

        try {
            fw = new FileWriter(outputFile, true);
            fw.write(content);
            fw.write("\n");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) {
                    fw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
