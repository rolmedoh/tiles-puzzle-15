# tiles-puzzle-15

##How to run it:

###Requeriments:
Maven
jdk-11-corretto

###Compile

Download the source code and execute:

mvn clean install

After all the test will create a folder target where you can find the test results and also the jar file.

run on terminal:
java -jar tiles-0.0.1-SNAPSHOT.jar

##Access

the service will create the memory database (h2) and you can access to the API url.

Also you can check the service status on the actuator URL:

localhost:8080/actuator/health

To check the project API documentation

localhost:8080/swagger-ui/

By default the memory database console is enable and the password is on the configuration file

localhost:8080/h2