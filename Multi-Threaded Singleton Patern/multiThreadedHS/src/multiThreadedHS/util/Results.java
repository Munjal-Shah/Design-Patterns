package multiThreadedHS.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

/*
 * @author Munjal Shah
 */
public class Results implements FileDisplayInterface, StdoutDisplayInterface {

    private static Results results;
    private List<Integer> finalList = new LinkedList();
    MergeSort mergeSort = new MergeSort();

    /**
     * Private constructor
     */
    private Results() {
        MyLogger.writeMessage("Private constructor called", MyLogger.DebugLevel.Results);
    }

    /**
     * Singleton Design pattern used to create only single instance
     *
     * @return
     */
    public static synchronized Results getInstance() {
        MyLogger.writeMessage("Object is returned if already created otherwisecreating it", MyLogger.DebugLevel.Results);
        if (results == null) {
            MyLogger.writeMessage("Creating object", MyLogger.DebugLevel.Results);
            results = new Results();
        }
        return results;
    }

    /**
     * This method is used to add list in the final list and then sort whole
     * list
     *
     * @param list
     */
    public synchronized void sortList(List list) {
        finalList.addAll(list);
        mergeSort.sort(finalList);
    }

    @Override
    public void writeToFile(String outputFile) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(outputFile, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            MyLogger.writeMessage("Writing to a file", MyLogger.DebugLevel.Results);
            for (Integer finalList1 : finalList) {
                bufferedWriter.write(finalList1.toString());
                bufferedWriter.write("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void writeToStdout(String s) {
        MyLogger.writeMessage("Writing to consloe", MyLogger.DebugLevel.Results);
        System.out.println(s);
    }

    @Override
    public void writeToStdout() {
        MyLogger.writeMessage("Writing to consloe", MyLogger.DebugLevel.Results);
        System.out.println(finalList);
    }
}
