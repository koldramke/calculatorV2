
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