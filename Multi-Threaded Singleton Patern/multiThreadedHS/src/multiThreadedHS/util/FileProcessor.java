package multiThreadedHS.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

/*
 * @author Munjal Shah
 */
public class FileProcessor {

    /**
     * This method reads line from file
     *
     * @param fileName
     * @return
     */
    public List readLine(String fileName) {

        List<Integer> list = new LinkedList<>();

        String line;
        File file = new File(fileName);
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            MyLogger.writeMessage("Reading a file", MyLogger.DebugLevel.FileProcessor);
            while ((line = br.readLine()) != null) {
                list.add(Integer.parseInt(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * This method is used to check if the file is empty
     *
     * @param fileName
     */
    public static void checkFileIsEmpty(String fileName) {
        MyLogger.writeMessage("Checking if file is empty", MyLogger.DebugLevel.FileProcessor);
        FileOutputStream fo = null;
        try {
            fo = new FileOutputStream(fileName);
            fo.write(("").getBytes());
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                if (fo != null) {
                    fo.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
