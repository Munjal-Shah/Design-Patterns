package studentCourseBackup.util;

import java.io.BufferedWriter;
import java.io.FileWriter;

/*
 * @author Munjal Shah
 */
public class Results implements FileDisplayInterface, StdoutDisplayInterface {

    public String outputFile = null;

    @Override
    public void writeToFile(String s) {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(outputFile, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            MyLogger.writeMessage("Writing to a file", MyLogger.DebugLevel.Driver);
            bufferedWriter.write(s);
            bufferedWriter.write("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if(fileWriter != null) {
                    fileWriter.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void writeToStdout(String s) {
        System.out.println(s);
    }
}
