Web Assessment excercise

Writing Tests
-------------
The test cases are written using JUnit framework in Java. You can find the test classes under the src/assessemnt_code directory.

Steps
-----
1.  Create new test classes or add test methods to existing classes as per your requirements.

2. Use Selenium WebDriver API to interact with web elements and perform actions such as clicking buttons, entering text, etc.
   
3. Use JUnit annotations such as @Test, @Before, @After for writing test methods and setup/teardown methods.
   
4. Running Tests
   
You can run the tests using your IDE

Future Improvements possible as due to time constraint and tools constraint I was not able to do.
-----------------------------------------------------------
1. Cross browser can be implemented easily. We can pass variable browser = chrome or firefox using pipeline variable and code will take care of browser capability and run it in the browser. We can also think of parallel execution and run same tests in 2 or more agents to support different browsers.
2. Maven can be installed and test can be run using command line mvn test. pom.xml file can take care of dependency.
3. These tests can be added as pipeline step either using Azure devops or jenkins or github Actions. As soon as code is build next step is to run test pipeline stage. Pipeline status will be passed or failed accordingly after test cases run.
4. Due to limited setup at my home device I tried to run tests using production sites. In ideal corporate world we can implement docker container where all the dependency and environment to run tests is there. Make docker image and during runtime create docker, deploy image and these tests can be run.
