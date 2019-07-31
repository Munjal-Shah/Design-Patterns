package myArrayList.driver;

import java.io.File;
import myArrayList.MyArrayList;
import myArrayList.test.MyArrayListTest;
import myArrayList.util.FileProcessor;
import myArrayList.util.Results;

/*
 * @author Munjal Shah
 */

public class Driver {

    public static void main(String[] args) {
        
        if(args.length <= 0 || args[0] == null || args[1] == null) {
            System.out.println("Please give input file and output file");
        }

        String inputfile = args[0];
        String outputfile = args[1];
        
        //String inputfile = "input.txt";
        //String outputfile = "output.txt";
        
        
        if(inputfile.isEmpty()) {
            System.out.println("Please enter valid inputfile path");
        }
        
        if(outputfile.isEmpty()) {
            try{
                File file = new File("output.txt");
                file.createNewFile();
                outputfile = "output.txt";
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        
        FileProcessor fp = new FileProcessor();
        Results results = new Results();
        MyArrayList myArrayList = new MyArrayList();
        
        fp.checkFileIsEmpty(outputfile);
        myArrayList = fp.readLine(inputfile);
        
        results.output = outputfile;
        results.initialize();
        
        int sum = myArrayList.sum();
        
        String out = "Sum of all values in array is: " + String.valueOf(sum);
        results.writeToFile(out);
        
        MyArrayListTest test = new MyArrayListTest();
        test.testCases(myArrayList, results);
        
        for(int i=0; i<results.tests; i++) {
            String s;
            if(results.getResults(i) != null) {
                s = "Test " + (i+1) + " " + results.getResults(i);
                results.writeToStdout(s);
            }
        }
    }
}