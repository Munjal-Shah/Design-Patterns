package multiThreadedHS.util;

import java.util.LinkedList;
import java.util.List;

/*
 * @author Munjal Shah
 * https://stackoverflow.com/questions/30875497/merge-sort-list-java
 */
public class MergeSort {

    /**
     * This method is used to sort list into individual elements
     *
     * @param list
     */
    public void sort(List<Integer> list) {
        MyLogger.writeMessage("Final list is getting sort into individual elements", MyLogger.DebugLevel.MergeSort);
        if (list.size() < 2) {
            return;
        }
        int mid = list.size() / 2;
        List<Integer> left = new LinkedList<>(list.subList(0, mid));
        List<Integer> right = new LinkedList<>(list.subList(mid, list.size()));

        sort(left);
        sort(right);
        merge(left, right, list);
    }

    /**
     * This method is used to merge all the single elements to a list
     *
     * @param left
     * @param right
     * @param list
     */
    private void merge(List<Integer> left, List<Integer> right, List<Integer> list) {
        MyLogger.writeMessage("Final list is getting merge from individual elements", MyLogger.DebugLevel.MergeSort);
        int leftIndex = 0;
        int rightIndex = 0;
        int listIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) < right.get(rightIndex)) {
                list.set(listIndex++, left.get(leftIndex++));
            } else {
                list.set(listIndex++, right.get(rightIndex++));
            }
        }
        while (leftIndex < left.size()) {
            list.set(listIndex++, left.get(leftIndex++));
        }
        while (rightIndex < right.size()) {
            list.set(listIndex++, right.get(rightIndex++));
        }
    }
}
