"C:\Program Files\Java\jdk1.8.0_101\bin\javac.exe" .\lights\src\co\alectronic\*.java
move .\lights\src\co\alectronic\*.class .
"C:\Program Files\Java\jdk1.8.0_101\bin\jar.exe" cvf fairylights.jar *.class
del *.class

"C:\Program Files\Java\jdk1.8.0_101\bin\java.exe" -jar fairylights.jar main.class

pause