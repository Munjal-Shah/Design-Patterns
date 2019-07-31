package myArrayList.test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import myArrayList.MyArrayList;
import myArrayList.util.Results;

/*
 * @author Munjal Shah
 */

public class MyArrayListTest {
    
    /**
     * This method is used to call all the test cases
     * @param myArrayList
     * @param results 
     */
    public void testCases(MyArrayList myArrayList, Results results) {
        arrayInsert(myArrayList, results, 5);
        arrayInsert(myArrayList, results, 11);
        arrayInsert(myArrayList, results, 96);
        arrayInsert(myArrayList, results, 69);
        arrayIndex(myArrayList, results, 11);
        arraySize(myArrayList, results);
        arraySum(myArrayList, results);
        arraySearch(myArrayList, results, 5);
        arrayInsertLargeNumber(myArrayList, results, 555555);
        arrayInsertNegativeNumber(myArrayList, results, -55555);
        arrayIncreaaseSize(myArrayList, results);
        arrayRemove(myArrayList, results, 96);
        arrayCompact(myArrayList, results, 11);
    }
    
    /**
     * Test case 1 to insert an element into arraylist
     * @param myArrayList
     * @param results
     * @param value 
     */
    public void arrayInsert(MyArrayList myArrayList, Results results, int value) {
        int old_size = myArrayList.size();
        myArrayList.insertSorted(value);
        int new_size = myArrayList.size();
        if(old_size + 1 == new_size) {
            results.storeNewResult("ArrayInsert test case: PASSED");
        }
        else {
            results.storeNewResult("ArrayInsert test case: FAILED");
        }
    }
    
    /**
     * Test case 2 to remove element from arraylist
     * @param myArrayList
     * @param results
     * @param value 
     */
    private void arrayRemove(MyArrayList myArrayList, Results results, int value) {
        int old_size = myArrayList.size();
        myArrayList.removeValue(value);
        int new_size = myArrayList.size();
        if(old_size == new_size + 1) {
            results.storeNewResult("ArrayRemove test case: FAILED");
        }
        else {
            results.storeNewResult("ArrayRemove test case: PASSED");
        }
    }
    
    /**
     * Test case 3 to compact arraylist
     * @param myArrayList
     * @param results
     * @param value 
     */
    private void arrayCompact(MyArrayList myArrayList, Results results, int value) {
        int old_size = myArrayList.size();
        myArrayList.removeValue(value);
        myArrayList.compact();
        int new_size = myArrayList.size();
        if(old_size > new_size) {
            results.storeNewResult("ArrayCompact test case: PASSED");
        }
        else {
            results.storeNewResult("ArrayCompact test case: FAILED");
        }
    }
    
    /**
     * Test case 4 to find index of given element in arraylist
     * @param myArrayList
     * @param results
     * @param value 
     */
    private void arrayIndex(MyArrayList myArrayList, Results results, int value) {
        int index = myArrayList.indexOf(value);
        if(index != -1) {            
            results.storeNewResult("ArrayIndex test case: PASSED");
        }
        else {
            results.storeNewResult("ArrayIndex test case: FAILED");
        }
    }
    
    /**
     * Test case 5 to find size of the arraylist
     * @param list
     * @param results 
     */
    private void arraySize(MyArrayList list, Results results) {
        int size = -123;
        size = list.size();
        if(size != -123) {
            results.storeNewResult("ArraySize test case: PASSED");
        }
        else {
            results.storeNewResult("ArraySize test case: FAILED");
        }
    }
    
    /**
     * Test case 6 to find sum of the elements in arraylist
     * @param myArrayList
     * @param results 
     */
    private void arraySum(MyArrayList myArrayList, Results results) {
        int old_sum = myArrayList.sum();
        myArrayList.insertSorted(511);
        int new_sum = myArrayList.sum();
        if(old_sum < new_sum) {
            results.storeNewResult("ArraySum test case: PASSED");
        }
        else {            
            results.storeNewResult("ArraySum test case: FAILED");
        }
    }
    
    /**
     * Test case 7 to print arraylist
     * @param myArrayList
     * @param results 
     */
    private void arraySearch(MyArrayList myArrayList, Results results, int value) {
        if(myArrayList.search(value)) {            
            results.storeNewResult("ArraySearch test case: PASSED");
        }
        else {            
            results.storeNewResult("ArraySearch test case: FAILED");
        }
    }
    
    /**
     * Test case 8 to insert large number which is greater than 10000
     * @param myArrayList
     * @param results
     * @param value 
     */
    private void arrayInsertLargeNumber(MyArrayList myArrayList, Results results, int value) {
        myArrayList.insertSorted(value);
        if(myArrayList.search(value)) {
            results.storeNewResult("ArrayInsertLargeNumber test case: FAILED");
        }
        else {
            results.storeNewResult("ArrayInsertLargeNumber test case: PASSED");
        }
    }
    
    /**
     * Test case 9 to insert negative number
     * @param myArrayList
     * @param results
     * @param value 
     */
    private void arrayInsertNegativeNumber(MyArrayList myArrayList, Results results, int value) {
        myArrayList.insertSorted(value);
        if(myArrayList.search(value)) {            
            results.storeNewResult("ArrayInsertNegativeNumber test case: FAILED");
        }
        else {            
            results.storeNewResult("ArrayInsertNegativeNumber test case: PASSED");
        }
    }
    
    /**
     * Test case 10 to increase size of arraylist
     * @param myArrayList
     * @param results 
     */
    private void arrayIncreaaseSize(MyArrayList myArrayList, Results results) {
        int old_size = myArrayList.length();
        int value;
        Random rand = new Random();
        
        for(int i=0; i<50; i++) {
            value = rand.nextInt(10000);
            if(value < 0) {
                value = value * -1;
            }
            myArrayList.insertSorted(value);
        }
        if(myArrayList.length() == old_size + 25) {
            results.storeNewResult("ArrayIncrease test case: PASSED");
        }
        else {
            results.storeNewResult("ArrayIncrease test case: FAILED");
        }
    }
}