package multiThreadedHS.threads;

import java.util.LinkedList;
import java.util.List;
import multiThreadedHS.util.FileProcessor;
import multiThreadedHS.util.MyLogger;
import multiThreadedHS.util.Results;

/*
 * @author Munjal Shah
 */
public class ThreadWorker extends Thread {

    String fileName = null;
    List<Integer> list = new LinkedList<>();
    Results results;

    /**
     * Constructor with parameters
     *
     * @param fileName
     * @param results
     */
    public ThreadWorker(String fileName, Results results) {
        MyLogger.writeMessage("Thread constructor called", MyLogger.DebugLevel.ThreadWorker);
        this.fileName = fileName;
        this.results = results;
    }

    @Override
    public void run() {
        try {
            MyLogger.writeMessage("Thread is running", MyLogger.DebugLevel.ThreadWorker);
            FileProcessor fileProcessor = new FileProcessor();
            list = fileProcessor.readLine(fileName);
            bubbleSort(list);
            results.sortList(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Bubble sort to sort list read from each file by each thread
     * https://www.geeksforgeeks.org/bubble-sort/
     *
     * @param l
     */
    private void bubbleSort(List<Integer> l) {
        MyLogger.writeMessage("List is getting sorted through bubble sort", MyLogger.DebugLevel.ThreadWorker);
        int n = l.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (l.get(j) > l.get(j + 1)) {
                    int temp = l.get(j);
                    l.set(j, l.get(j + 1));
                    l.set(j + 1, temp);
                }
            }
        }
    }
}
