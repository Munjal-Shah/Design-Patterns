package multiThreadedHS.driver;

import multiThreadedHS.threads.ThreadWorker;
import multiThreadedHS.util.FileProcessor;
import multiThreadedHS.util.MyLogger;
import multiThreadedHS.util.Results;

/*
 * @author Munjal Shah
 */
public class Driver {

    public static void main(String[] args) {

        if (args.length < 4 || args.length > 6) {
            System.out.println("Please give input file, output file & debug value");
            System.exit(0);
        }
        
        if((Integer.parseInt(args[0])) < 1 && (Integer.parseInt(args[0]) > 3)) {
            System.out.println("Please enter first argument between 1 to 3");
            System.exit(0);
        }

        try {
            MyLogger.writeMessage("Setting debug level to " + args[5], MyLogger.DebugLevel.Driver);
            MyLogger.debugValue(Integer.parseInt(args[5]));
        } catch (Exception e) {
            MyLogger.debugValue(555);
        }

        Results results = Results.getInstance();

        int n = Integer.parseInt(args[0]);
        String outputFile = args[n + 1];
        //int n = 3;
        //String outputFile = "output.txt";

        for (int i = 1; i <= n; i++) {
            try {
                ThreadWorker threadWorker = new ThreadWorker(args[i], results);
                //ThreadWorker threadWorker = new ThreadWorker("input.txt", results);
                MyLogger.writeMessage("Thread " + i + " created", MyLogger.DebugLevel.Driver);
                threadWorker.start();
                threadWorker.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        FileProcessor.checkFileIsEmpty(outputFile);
        results.writeToFile(outputFile);
    }
}
