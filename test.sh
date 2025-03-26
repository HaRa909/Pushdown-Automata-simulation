#javac -cp ".;..\libs\junit-4.13.2.jar;..\libs\hamcrest-2.2.jar" CustomTester.java
#java -cp ".;..\libs\junit-4.13.2.jar;..\libs\hamcrest-2.2.jar" org.junit.runner.JUnitCore  CustomTester

javac -cp . Main.java newPDA.java
java -cp . Main



#javac -cp ".;..\libs\junit-4.13.2.jar;..\libs\hamcrest-2.2.jar" PublicTester.java 
#java -cp ".;..\libs\junit-4.13.2.jar;..\libs\hamcrest-2.2.jar" org.junit.runner.JUnitCore PublicTester 
#java -jar checkstyle-10.7.0-all.jar -c checkstyle.xml MyBST.java
#In the terminal, run java -jar checkstyle-10.7.0-all.jar -c checkstyle.xml [your java file],
# for example, java -jar checkstyle-10.7.0-all.jar -c checkstyle.xml MyLinkedList.java. 
#You'll see a list of errors that indicate style issues in your code.