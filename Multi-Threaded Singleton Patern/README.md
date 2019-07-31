# CSX42: Assignment 4
## Name: Munjal Shah

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in multiThreadedHS/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: 
ant -buildfile multiThreadedHS/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile multiThreadedHS/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: 
ant -buildfile multiThreadedHS/src/build.xml run -Dargs = <N> <input1.txt> <input2.txt> <input3.txt> <output.txt> <debugValue>

Example:

The last argument is the Logger value. 
ant -buildfile multiThreadedHS/src/build.xml run -Dargs = N input1.txt input2.txt input3.txt output.txt debugValue


-----------------------------------------------------------------------
## Description:
Using list to store data from input files and also in Results.
To add in list: O(1)
To get from list: O(n)
Bubblesort: O(n^2)
Merge sort: O(n logn)


-----------------------------------------------------------------------
## Citation:
https://stackoverflow.com/questions/30875497/merge-sort-list-java
https://www.geeksforgeeks.org/bubble-sort/


-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense."

Date: 07/22/2019 