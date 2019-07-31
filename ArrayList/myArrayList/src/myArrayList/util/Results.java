package myArrayList.util;

import java.io.BufferedWriter;
import java.io.FileWriter;

/*
 * @author Munjal Shah
 */
public class Results implements FileDisplayInterface, StdoutDisplayInterface {

    public FileWriter fw = null;
    public String output = null;
    public StdoutDisplayInterface sdi;
    public FileDisplayInterface fdi;
    public int tests = 0;
    private String testCases[] = new String[50];

    /**
     * This method writes to file
     * @param s 
     */
    @Override
    public void writeToFile(String s) {
        try {
            fw = new FileWriter(output);
            fw.write(s);
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

    /**
     * This method gives output on console
     * @param s 
     */
    @Override
    public void writeToStdout(String s) {
        System.out.println(s);
    }
    
    /**
     * This method is used to initialize objects
     */
    public void initialize() {
        sdi = new Results();
        fdi = new Results();
    }

    /**
     * This method is used to store result in an array
     * @param str 
     */
    public void storeNewResult(String str) {
        testCases[tests] = str;
        tests++;
    }

    /**
     * This method is used to get all the result in string
     * @param index
     * @return 
     */
    public String getResults(int index) {
        String r = null;
        for (int i = 0; i <= tests; i++) {
            if (i == index) {
                r = testCases[i];
            }
        }
        return r;
    }
}