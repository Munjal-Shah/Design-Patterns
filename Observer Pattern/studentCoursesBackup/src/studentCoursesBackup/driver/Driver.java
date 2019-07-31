package studentCourseBackup.driver;

import studentCourseBackup.StudentCoursesBackup;
import studentCourseBackup.util.FileProcessor;
import studentCourseBackup.util.MyLogger;

/*
 * @author Munjal Shah
 */
public class Driver {

    public static void main(String[] args) {

        if (args[0] == null || args[1] == null || args[2] == null || args[3] == null || args[4] == null || args[5] == null) {
            System.out.println("Please give input file, output file & debug value");
            System.exit(0);
        }

        String input = args[0];
        String delete = args[1];
        String output1 = args[2];
        String output2 = args[3];
        String output3 = args[4];

        /*String input = "input.txt";
        String delete = "delete.txt";
        String output1 = "output1.txt";
        String output2 = "output2.txt";
        String output3 = "output3.txt";*/

        try {
            MyLogger.writeMessage("Setting debug level to " + args[5], MyLogger.DebugLevel.Driver);
            MyLogger.debugValue(Integer.parseInt(args[5]));
        } catch (Exception e) {
            MyLogger.debugValue(555);
        }

        FileProcessor.checkFileIsEmpty(output1);
        FileProcessor.checkFileIsEmpty(output2);
        FileProcessor.checkFileIsEmpty(output3);

        StudentCoursesBackup studentCoursesBackup = new StudentCoursesBackup();
        MyLogger.writeMessage("Calling readInitialize in StudentCoursesBackup", MyLogger.DebugLevel.Driver);
        studentCoursesBackup.readInitialize(input, delete, output1, output2, output3);
    }
}
