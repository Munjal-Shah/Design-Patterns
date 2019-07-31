package racingDrivers.driver;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import racingDrivers.race.RaceContext;
import racingDrivers.util.FileProcessor;

/*
 * @author Munjal Shah
 */
public class Driver {

    public static void main(String[] args) {
        if (args.length <= 0 || args[0] == null || args[1] == null || args[2] == null) {
            System.out.println("Please give input file, output file and debug value");
        }

        String inputfile = args[0];
        String outputfile = args[1];
        try {
            int debug_value = Integer.parseInt(args[2]);
            
            if(debug_value < 0 && debug_value > 4) {
                System.out.println("Debug value must have range 0 to 4");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        

//    String inputfile = "input.txt";
//    String outputfile = "output.txt";
//    int debug_value = 2;
        List<String> driverDistanceList;

        if (inputfile.isEmpty()) {
            System.out.println("Please enter valid inputfile path");
        }

        if (outputfile.isEmpty()) {
            try {
                File file = new File("output.txt");
                file.createNewFile();
                outputfile = "output.txt";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        FileProcessor fp = new FileProcessor(inputfile, outputfile);
        fp.readLine(inputfile);
    }
}
