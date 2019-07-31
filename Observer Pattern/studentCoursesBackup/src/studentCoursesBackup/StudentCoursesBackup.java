package studentCourseBackup;

import java.util.LinkedList;
import java.util.List;
import studentCourseBackup.util.FileProcessor;
import studentCourseBackup.util.MyLogger;
import studentCourseBackup.util.StudentData;
import studentCourseBackup.util.Tree;

/*
 * @author Munjal Shah
 */
public class StudentCoursesBackup {

    Tree tree = new Tree();
    StudentData student;
    public List<String> outmsg = new LinkedList<>();
    public List<String> insertData;
    public List<String> deleteData;
    public int count = 0;

    /**
     * This method gets input file into list and then adds courses to the
     * StudentData
     *
     * @param inputFile
     * @throws CloneNotSupportedException
     */
    private void readInputFile(String inputFile) {
        MyLogger.writeMessage("Reading bNumber & subjects which are to be added in Tree", MyLogger.DebugLevel.StudentCoursesBackup);
        FileProcessor fileProcessor = new FileProcessor();
        insertData = fileProcessor.readLine(inputFile);

        for (String insertdata1 : insertData) {
            String[] insertStudentData = insertdata1.split(":");
            int bNumber = Integer.parseInt(insertStudentData[0]);
            String subject = insertStudentData[1];
            try {
                MyLogger.writeMessage("Addiding node to tree", MyLogger.DebugLevel.StudentCoursesBackup);
                tree.addCourse(bNumber, subject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This method gets delete file into list and then deletes courses from the
     * StudentData
     *
     * @param deleteFile
     * @throws CloneNotSupportedException
     */
    private void readDeleteFile(String deleteFile) {
        MyLogger.writeMessage("Reading bNumber & subjects which are to be deleted from Tree", MyLogger.DebugLevel.StudentCoursesBackup);
        FileProcessor fileProcessor = new FileProcessor();
        deleteData = fileProcessor.readLine(deleteFile);

        for (String deleteData1 : deleteData) {
            String[] deleteStudentData = deleteData1.split(":");
            int bNumber = Integer.parseInt(deleteStudentData[0]);
            String subject = deleteStudentData[1];
            try {
                MyLogger.writeMessage("Deleting course from tree", MyLogger.DebugLevel.StudentCoursesBackup);
                tree.deleteCourse(bNumber, subject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This method will call readInputFile, readDeleteFile & print data to files
     *
     * @param input
     * @param delete
     * @param output1
     * @param output2
     * @param output3
     */
    public void readInitialize(String input, String delete, String output1, String output2, String output3) {
        MyLogger.writeMessage("Calling readInputFile", MyLogger.DebugLevel.StudentCoursesBackup);
        readInputFile(input);
        MyLogger.writeMessage("Calling readDeleteFile", MyLogger.DebugLevel.StudentCoursesBackup);
        readDeleteFile(delete);
        MyLogger.writeMessage("Calling print method to print tree in all output files", MyLogger.DebugLevel.StudentCoursesBackup);
        tree.printDataToFiles(output1, output2, output3);
    }
}
