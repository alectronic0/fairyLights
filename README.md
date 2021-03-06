# fairyLights
[![Build Status](https://travis-ci.org/alectronic0/fairyLights.svg?branch=master)](https://travis-ci.org/alectronic0/fairyLights)
[![codecov](https://codecov.io/gh/alectronic0/fairyLights/branch/master/graph/badge.svg)](https://codecov.io/gh/alectronic0/fairyLights)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/01790438455e4df98250f01d940870f3)](https://www.codacy.com/app/alectronic0/fairyLights)
## intro

The exercise is to write a controller for a length of fairy lights.  There are 20 fairy lights in alternating colours red, green and white that can be independently turned on and off. 
The controller is a java program that accepts (as a command line parameter) the name of a sequencing algorithm for turning the lights on and off.  When launched, the program will execute the requested sequencing algorithm in a permanent loop until it the program is terminated.  

To Compile run the Light.bat File (modify the path for your javac, jar and java cmd as needed)

## Quickstart
Locally:
```bash
git clone https://github.com/alectronic0/fairyLights.git
cd fairyLights
mvn clean install
#
#java -jar target/fairylight.jar ["sequence" | "sequence" | "alternate"] numberOfLights
#
java -jar target/fairylight.jar "sequence"
java -jar target/fairylight.jar "colour"
java -jar target/fairylight.jar "alternate" 
#
java -jar target/fairylight.jar "sequence" "15"
```
Docker:
```bash
git clone https://github.com/alectronic0/fairyLights.git
cd fairyLights
mvn clean install
docker-compose up
```


## Reports & Tests
I've added the following reports:
- Jacoco Coverage
- Owasp Dependency Check
- Junit Test

Run this and the report will displaed on your default browser (Linux or Mac)
```bash
./testme.sh
```
