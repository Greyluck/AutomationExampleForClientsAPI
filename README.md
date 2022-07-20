# Automation example for new clients
# By Emilio Ontiveros
# Contact: EmilioAgustinOntiveros@gmail.com

Intro:
---
In this directory you will find the following 
 **Main folders**
 - **Documentation:** Here will be drop any documentation that could help you to navigate the project.
 - **Project:** The project that will execute the tests.

Overview of this project:
---
The project uses the following:
 - Java
 - Maven (Maven is used to define project structure, dependencies, build, and test management.)
 - Selenium WebDriver (Selenium is used to perfom Web/UI testing)
 - JUnit

Executable files
---
To facilitate the use of this project, there will be one or more executable files that can help to perfom several tasks.

Manual tests
---
**Testing**
To start a test manually follow this indications:

  Before start testing
  - Maven should be installed before executing the test.
  - The Chrome Driver should be updated if needed.

  Starting
  1) Open a CMD.
  2) In the console go the folder where the this readme is located.
  3) Use the "cd Project\AutomaticTestForDemo" to access to the folder where the maven test will be executed.
  4) Execute the command "mvn clean install test -Dtest=AppTest" to execute the main test, this will trigger the execution.
     - If dependencies are needed, they will be downloaded before the test.
