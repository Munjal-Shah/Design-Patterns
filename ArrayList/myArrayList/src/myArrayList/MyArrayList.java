package myArrayList;

import java.util.Arrays;
import java.util.Stack;
import myArrayList.util.FileProcessor;

/*
 * @author Munjal Shah
 */

public class MyArrayList {

    private int[] readList;
    private int listSize;
    public Stack<Integer> stack;

    /**
     * This is a default constructor to assign 
     * values when object is created
     */
    public MyArrayList() {
        readList = new int[50];
        //Arrays.fill(readList, Integer.MAX_VALUE);
        listSize = 0;
        stack = new Stack<>();
    }
    
    /**
     * This method is used to add values in myarraylist
     * @param newValue 
     */
    public void insertSorted(int newValue) {
        if (newValue >= 0 && newValue <= 10000) {
            if (listSize == readList.length) {
                increaseSize();
            }
            readList[listSize] = newValue;
            listSize++;
            stack.push(newValue);
            Arrays.sort(readList);
            //sort();
        }
    }

    /**
     * This method is used to increase size of myarraylist
     */
    public void increaseSize() {
        int temp[] = new int[listSize];
        int i = 0;
        while (i < readList.length) {
            temp[i] = readList[i];
            i++;
        }
        readList = null;
        //readList = Arrays.copyOf(temp, listSize + (listSize / 2));
        readList = new int[listSize + (listSize / 2)];
        int j = 0;
        while(j < temp.length) {
            readList[j] = temp[j];
            j++;
        }
    }

    /**
     * This method is used to print myarraylist
     * in order which elements where added
     */
    public void printInsertionOrder() {
        while(stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    /**
     * This method is used to remove element
     * from my arraylist
     * @param value 
     */
    public void removeValue(int value) {
        for (int i = 0; i < readList.length; i++) {
            if (readList[i] == value) {
                for (int j = i; j < listSize; j++) {
                    readList[j] = readList[j + 1];
                }
                listSize--;
                stack.remove(value);
            }
        }
    }
    
    /**
     * This method is used to compact
     * size of myarraylist
     */
    public void compact() {
        int temp[] = new int[listSize];
        int i = 0;
        while(i < listSize) {
            temp[i] = readList[i];
            i++;
        }
        readList = null;
        readList = new int[listSize];
        int j = 0;
        while(j < temp.length) {
            readList[j] = temp[j];
            j++;
        }
    }

    /**
     * This method is used to get the position
     * of an element in myarraylist
     * @param value
     * @return 
     */
    public int indexOf(int value) {
        for (int i = 0; i < readList.length; i++) {
            if (value == readList[i]) {
                return i+1;
            }
        }
        return -1;
    }

    /**
     * This method returns the size of myarraylist
     * @return 
     */
    public int size() {
        return listSize;
    }
    
    /**
     * This method returns the length of myarraylist
     * @return 
     */
    public int length() {
        return readList.length;
    }

    /**
     * This method gives the sum of
     * all the elements in myarraylist
     * @return 
     */
    public int sum() {
        int sum = 0;
        for (int i = 0; i < readList.length; i++) {
            sum = sum + readList[i];
        }
        return sum;
    }
    
    /**
     * This method returns true if element
     * exists in myarraylist else returns false
     * @param value
     * @return 
     */
    public boolean search(int value) {
        for(int i=0; i<readList.length; i++) {
            if(readList[i] == value) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method is used to print myarraylist
     * @return 
     */
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < listSize; i++) {
            s = s + readList[i] + " ";
        }
        return s;
    }
}