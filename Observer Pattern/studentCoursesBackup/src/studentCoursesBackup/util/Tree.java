package studentCourseBackup.util;

import studentCourseBackup.myTree.Node;

/*
 * @author Munjal Shah
 */
public class Tree {

    Node root;
    Node backup1;
    Node backup2;
    boolean check = true;

    public Node getBackup1() {
        return backup1;
    }

    public void setBackup1(Node backup1) {
        this.backup1 = backup1;
    }

    public Node getBackup2() {
        return backup2;
    }

    public void setBackup2(Node backup2) {
        this.backup2 = backup2;
    }

    /**
     * This method calls insert method to add courses to studentData and create
     * node
     *
     * @param bNumber
     * @param subject
     * @throws CloneNotSupportedException
     */
    public void addCourse(int bNumber, String subject) throws CloneNotSupportedException {
        MyLogger.writeMessage("Adding new course", MyLogger.DebugLevel.Tree);
        root = insert(root, bNumber, subject);
        backup1 = root.clone();
        backup2 = root.clone();
        root.registerObserver(backup1);
        root.registerObserver(backup2);
    }

    /**
     * This method inserts data into StudentData and creates node
	 * https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
     *
     * @param root
     * @param bNumber
     * @param subject
     * @return
     * @throws CloneNotSupportedException
     */
    private Node insert(Node root, int bNumber, String subject) throws CloneNotSupportedException {
        if (root == null) {
            MyLogger.writeMessage("Creating new node of student data", MyLogger.DebugLevel.Tree);
            StudentData student = new StudentData(bNumber);
            student.addSubject(subject);
            Node node = new Node(student);
            return node;
        }

        if (bNumber < root.studentData.getbNumber()) {
            MyLogger.writeMessage("Going to left side to add node", MyLogger.DebugLevel.Tree);
            Node node = insert(root.left, bNumber, subject);
            root.left = node;
            backup1.left = node.clone();
            backup2.left = node.clone();
            node.registerObserver(backup1);
            node.registerObserver(backup2);
        } else if (bNumber > root.studentData.getbNumber()) {
            MyLogger.writeMessage("Going to right side to add node", MyLogger.DebugLevel.Tree);
            Node node = insert(root.right, bNumber, subject);
            root.right = node;
            backup1.right = node.clone();
            backup2.right = node.clone();
            node.registerObserver(backup1);
            node.registerObserver(backup2);
        } else if (bNumber == root.studentData.getbNumber()) {
            MyLogger.writeMessage("Adding course to existing student", MyLogger.DebugLevel.Tree);
            root.studentData.addSubject(subject);
            backup1.notifyObserver(Node.Operations.insert);
            backup2.notifyObserver(Node.Operations.insert);
            return root;
        }
        return root;
    }

    /**
     * This method calls delete method to delete subject from the node
     *
     * @param bNumber
     * @param subject
     * @throws CloneNotSupportedException
     */
    public void deleteCourse(int bNumber, String subject) throws CloneNotSupportedException {
        MyLogger.writeMessage("Deleting course", MyLogger.DebugLevel.Tree);
        root = delete(root, bNumber, subject);
    }

    /**
     * This method deletes subject from StudentData
	 * https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
     *
     * @param root
     * @param bNumber
     * @param subject
     * @return
     * @throws CloneNotSupportedException
     */
    private Node delete(Node root, int bNumber, String subject) throws CloneNotSupportedException {
        if (root == null) {
            return null;
        }

        if (bNumber < root.studentData.getbNumber()) {
            MyLogger.writeMessage("Checking left child", MyLogger.DebugLevel.Tree);
            Node node = delete(root.left, bNumber, subject);
            root.left = node;
            backup1.left = node.clone();
            backup2.left = node.clone();
        } else if (bNumber > root.studentData.getbNumber()) {
            MyLogger.writeMessage("Checking right child", MyLogger.DebugLevel.Tree);
            Node node = delete(root.right, bNumber, subject);
            root.right = node;
            backup1.right = node.clone();
            backup2.right = node.clone();
        } else if (bNumber == root.studentData.getbNumber()) {
            MyLogger.writeMessage("Node found deleting course", MyLogger.DebugLevel.Tree);
            if (root.studentData.getSubjects().contains(subject)) {
                root.studentData.deleteSubject(subject);
                backup1.notifyObserver(Node.Operations.delete);
                backup2.notifyObserver(Node.Operations.delete);
                /**
                 * Code for deleting node if student has no course
                 */
                /*if (root.studentData.getSubjects().isEmpty()) {
                    MyLogger.writeMessage("Courses are empty so deleting StudentData node", MyLogger.DebugLevel.Tree);
                    if (root.left != null && root.right != null) {
                        Node temp = root;
                        Node minNodeForRight = minimumElement(temp.right);
                        root.studentData = minNodeForRight.studentData;
                        delete(root.right, minNodeForRight.studentData.getbNumber(), minNodeForRight.studentData.getSubjects().iterator().next());
                    } else if (root.left != null) {
                        root = root.left;
                    } else if (root.right != null) {
                        root = root.right;
                    } else {
                        root = null;
                    }
                }*/
            } else {
                return root;
            }
        }
        return root;
    }

    /**
     * This method writes to output file when it is called
     *
     * @param output1
     * @param output2
     * @param output3
     */
    public void printDataToFiles(String output1, String output2, String output3) {
        inorder(root, output1);
        inorder(backup1, output2);
        inorder(backup2, output3);
    }

    /**
     * This method finds minimum element from the tree
     *
     * @param root
     * @return
     */
    public static Node minimumElement(Node root) {
        if (root.left == null) {
            return root;
        } else {
            return minimumElement(root.left);
        }
    }

    Results results = new Results();

    /**
     * This method prints tree in inorder form to file
     *
     * @param root
     * @param outputFile
     */
    private void inorder(Node node, String outputFile) {
        MyLogger.writeMessage("Searching and printing", MyLogger.DebugLevel.Tree);
        results.outputFile = outputFile;
        if (node != null) {
            inorder(node.left, outputFile);
            results.writeToFile("Student with BNumber " + node.studentData.getbNumber() + " has subjects " + node.studentData.getSubjects());
            //results.writeToStdout("Student with BNumber " + node.studentData.getbNumber() + " has subjects " + node.studentData.getSubjects());
            inorder(node.right, outputFile);
        }
    }
}
