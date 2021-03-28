# tiles-puzzle-15

## How to run it:

### Requeriments:
Maven
jdk-11-corretto

### Compile

Download the source code and execute:

mvn clean install

After all the test will create a folder target where you can find the test results and also the jar file.

run on terminal:
java -jar tiles-0.0.1-SNAPSHOT.jar

## Access

the service will create the memory database (h2) and you can access to the API url.

Also you can check the service status on the actuator URL:

localhost:8080/actuator/health

To check the project API documentation

localhost:8080/swagger-ui/

By default the memory database console is enable and the password is on the configuration file

localhost:8080/h2

## Scalability

The service uses jpa so shouln't be difficult to adapt it to a share database. Depending of the servers the number os workers can be edited.
For the quick solution I will pick an HA-proxy or any service that can be use as proxy. Usually I set a header value (that is why is on the api) to check where the connection is authorized to send request but right now is on blank.

For a long run solution I can imagine docker and autodiscover. With autodeploy and a pipeline that can do it automatically.
