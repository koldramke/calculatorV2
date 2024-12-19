
# Calculator API 


This project is a Spring Boot application that performs a RESTful API for basic mathematic operations - addition, subtraction, multiplication and division.    
It also integrates with Apache Kafka for messaging, allowing the application to send and receive messages through Kafka topics.

### Main Operations

**Arithmetic Operations** 

    Addition
    Subtraction
    Multiplication
    Division (with division by zero error handling)

**Kafka Integration:** 

    The API integrates with Apache Kafka for sending and receiving messages.

    Producer: Sends messages to a Kafka topic.
    Consumer: Listens for messages from the Kafka topic and logs them.



## Build and Run the project

#### Tools to run the application

- [x]   Java (17, 21 or 23 versions)
- [x]   Apache Maven
- [x]   Docker
- [x]   Apache Kafka and Zookeeper (through Docker) 

#### Download the git repository

```bash
  https://github.com/koldramke/calculatorV2.git
```

#### After downloading 
Access the project directory where the **pom.xml** file is located (the root of the module) - it's used to build the project with Apache Maven:

```bash
  cd calculatorV2/calculator

```
### *Make sure that you are always in the directory **calculatorV2/calculator (command line) for building and running the application from now on!***





#### Building the Spring Boot using Apache Maven

in the directory ***calculatorV2/calculator*** use the command below, to compile and build the project:
```bash
  mvn clean package

```
once is done successfully you will see this printed message in CLI:

```bash
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------

```
#### Run the application
in the directory ***calculatorV2/calculator*** use the command below, to run the Spring Boot application and open a server port in url» http://localhost.3000
```bash
java -jar target/calculator-0.0.1-SNAPSHOT.jar
```
Let it open and do not close the command line! Follow the next step (Running Tests)





## Running Tests
A couple of options could be made to run the Calculator API, but two examples are showed below: running in the web browser and in the CLI as a HTTP request.
#### Browser
Open the browser to test the Calculator API. Once in the browser send a requisition. For example:

```bash
http://localhost:3000/div?a=487&b=10
```
The response back is a JSON file directly in the webpage:
```bash
result	48.7
```

```bash
HTTP/1.1 200 
Connection: keep-alive
Content-Type: application/json
Date: Thu, 19 Dec 2024 17:13:17 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

{
    "result": 24837
}
```

#### HTTP Request

in the directory ***calculatorV2/calculator*** use the command below, to request a logic operation. For example:
```bash
http GET "http://localhost:3000/mul?a=487&b=51"

```
The response expected
```bash
HTTP/1.1 200 
Connection: keep-alive
Content-Type: application/json
Date: Thu, 18 Dec 2024 20:13:17 GMT
Keep-Alive: timeout=60
Transfer-Encoding: chunked

{
    "result": 24837
}

```

## Running Unit Tests
Two forms of unit and integration tests are possible: by using Apache Maven and Docker.
#### Apache Maven

1.Make sure the build project is not running anymore;

2.Access to the directory ***calculatorV2/calculator*** use the command below, to compile the project, run the unit tests using Maven and then show all the results in the CLI:
```bash
mvn test

```
Tests are performed in the java files in the directory: 
```bash
calculatorV2/calculator/src/test/java/com/api/calculator

```

The test result must be something like:
```bash
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 12, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  13.470 s
[INFO] Finished at: 2024-12-18T20:26:32Z
[INFO] ------------------------------------------------------------------------
```
#### Docker
Access to the directory ***calculatorV2/calculator*** use the command below, it can be runned by docker, building a Docker image. 
```bash
docker build -t calculator .

```
Run the unit tests that are in the Docker container:
```bash
docker run -it calculator mvn test

```


## Author

> Eduardo Grilo
- [@koldramke](https://github.com/koldramke)

