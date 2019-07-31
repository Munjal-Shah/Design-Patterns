# CSX42: Assignment 3
## Name: Munjal Shah

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in studentCoursesBackup/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: 
ant -buildfile studentCoursesBackup/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile studentCoursesBackup/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: 
ant -buildfile studentCourseBackup/src/build.xml run -Darg0=<inputFile.txt> -Darg1=<deleteFile.txt> -Darg2=<outputFile1.txt> -Darg3=<outputFile2.txt> -Darg4=<outputFile3.txt>

Example:

The last argument is the Logger value. 
ant -buildfile studentCourseBackup/src/build.xml run -Darg0=inputFile.txt -Darg1=deleteFile.txt -Darg2=outputFile1.txt -Darg3=outputFile2.txt -Drag4=outputFile3.txt



-----------------------------------------------------------------------
## Description:
I've used Binary search tree as it is easy to search through tree and Deleting a node is also easy in binary search tree.
For storing subjects I've used Set data structure as it won't allow any duplicate values.
Time complexity of BST:
Insert: O(n)
Delete: O(n)
Search: O(n)
where n is height of tree


-----------------------------------------------------------------------
## Citation:
https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
https://www.geeksforgeeks.org/set-in-java/


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
offense.""

Date: 07/09/2019 