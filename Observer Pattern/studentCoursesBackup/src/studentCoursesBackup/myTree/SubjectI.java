package studentCourseBackup.myTree;

import studentCourseBackup.myTree.Node.Operations;

/*
 * @author Munjal Shah
 */
public interface SubjectI {

    /**
     *
     * @param observerI
     */
    void registerObserver(ObserverI observerI);

    /**
     *
     * @param observerI
     */
    void removeObserver(ObserverI observerI);

    /**
     *
     * @param operations
     */
    void notifyObserver(Operations operations);

}
