package studentCourseBackup.myTree;

import studentCourseBackup.myTree.Node.Operations;
import studentCourseBackup.util.StudentData;

/*
 * @author Munjal Shah
 */
public interface ObserverI {

    /**
     * 
     * @param studentData
     * @param operations 
     */
    void updateSubjects(StudentData studentData, Operations operations);
}
