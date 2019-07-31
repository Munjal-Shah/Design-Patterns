package myArrayList.util;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import myArrayList.MyArrayList;

/*
 * @author Munjal Shah
 */

public class FileProcessor {
    
    MyArrayList list = new MyArrayList();
    
    /**
     * This method reads line by line from
     * file and stores in the list
     * @param fileName
     * @return 
     */
    public MyArrayList readLine(String fileName) {
        
        String line = null;
        File file = new File(fileName);
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            line = br.readLine();
            while(line != null) {
                list.insertSorted(Integer.parseInt(line));
                line = br.readLine();
            } 
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(fr != null) {
                    fr.close();
                }
                if(br != null) {
                    br.close();
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    
    /**
     * This method checks if the file
     * is empty or not
     * @param filename 
     */
    public static void checkFileIsEmpty(String filename) {
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream(filename);
            fout.write(("").getBytes());
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(fout != null) {
                    fout.close();
                }
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            
        }
    }
}