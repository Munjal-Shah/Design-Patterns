# CSX42: Assignment 5
## Name: Munjal Shah

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in troubleShootSearch/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: 
ant -buildfile troubleShootSearch/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile troubleShootSearch/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command:

ant -buildfile troubleShootSearch/src/build.xml run -Darg0=<userInput.txt> -Darg1=<productA.txt> -Darg2=<productB.txt> -Darg3=<productC.txt> -Darg4=<productD.txt> -Darg5=<synonyms.txt> -Darg6=<output.txt> -Darg7=<DebugValue>

Example:

The last argument is the Logger value. 
ant -buildfile troubleShootSearch/src/build.xml run -Darg0=userInput.txt -Darg1=productA.txt -Darg2=productB.txt -Darg3=productC.txt -Darg4=productD.txt -Darg5=synonyms.txt -Darg6=output.txt -Darg7=DebugValue


-----------------------------------------------------------------------
## Description:
As Described there will be 4 products which will have technical sentences, those 4 products will be given as an input.
A keyword to be search will be also given in input.
For semantic search synonyms will be given in input.
And an outputfile where all the products output will be printed with all 3 search results.


-----------------------------------------------------------------------
## Citation:
https://www.youtube.com/watch?v=pL4mOUDi54o


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

Date: 08/05/2019 