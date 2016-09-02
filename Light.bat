cd ./src
"C:\Program Files\Java\jdk1.8.0_101\bin\javac.exe" .\co\alectronic\*.java

"C:\Program Files\Java\jdk1.8.0_101\bin\jar.exe" cvfm ../fairylights.jar ../manifest.mf .\co\alectronic\*.class

cd ..

"C:\Program Files\Java\jdk1.8.0_101\bin\jar.exe" tf fairylights.jar

 del .\src\co\alectronic\*.class

::Run one of the cmds
::"C:\Program Files\Java\jdk1.8.0_101\bin\java.exe" -jar fairylights.jar
::"C:\Program Files\Java\jdk1.8.0_101\bin\java.exe" -jar fairylights.jar "Colour"
::"C:\Program Files\Java\jdk1.8.0_101\bin\java.exe" -jar fairylights.jar "Colour"
"C:\Program Files\Java\jdk1.8.0_101\bin\java.exe" -jar fairylights.jar "Colour"
