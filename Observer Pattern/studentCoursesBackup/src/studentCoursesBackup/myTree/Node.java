package studentCourseBackup.myTree;

import java.util.LinkedList;
import java.util.List;
import studentCourseBackup.util.MyLogger;
import studentCourseBackup.util.StudentData;

/*
 * @author Munjal Shah
 */
public class Node implements ObserverI, SubjectI, Cloneable {

    public Node left;
    public Node right;
    public StudentData studentData;
    public List<ObserverI> observers = new LinkedList<>();

    /**
     * Parameterised Node constructor
     *
     * @param studentData
     */
    public Node(StudentData studentData) {
        MyLogger.writeMessage("Node parameterised constructor", MyLogger.DebugLevel.Node);
        this.studentData = studentData;
        left = null;
        right = null;
    }

    /**
     * This method clones node
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public Node clone() {
        Node node = null;
        try {
            node = (Node) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return node;
    }

    /**
     * This method updates subject as insert or delete
     *
     * @param studentData
     * @param operations
     */
    @Override
    public void updateSubjects(StudentData studentData, Operations operations) {
        MyLogger.writeMessage("Updating subjects in backup1 & backup2", MyLogger.DebugLevel.Node);
        switch (operations) {
            case insert:
                this.studentData = studentData;
                break;

            case delete:
                this.studentData = studentData;
                break;
        }
    }

    @Override
    public void registerObserver(ObserverI observerI) {
        MyLogger.writeMessage("Registering all observers", MyLogger.DebugLevel.Node);
        observers.add(observerI);
    }

    @Override
    public void removeObserver(ObserverI observerI) {
        MyLogger.writeMessage("Removing an observer", MyLogger.DebugLevel.Node);
        observers.remove(observerI);
    }

    @Override
    public void notifyObserver(Operations operations) {
        MyLogger.writeMessage("Notifying all observers", MyLogger.DebugLevel.Node);
        for (ObserverI observerI : observers) {
            observerI.updateSubjects(studentData, operations);
        }
    }

    public enum Operations {

        insert,
        delete
    }
}
