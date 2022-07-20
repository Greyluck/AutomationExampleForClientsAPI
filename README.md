# Automation example for new clients

Intro:
---
In this directory you will find three folder
 - **Documentation:** Here you will find any documentation that could help you to navigate the project.
 - **ExampleWeb:** This folder contains a simple web page that is hosted online. It was created to show the automation in action.
 - **Project:** This folder contains the project that will execute the tests.

Overview:
---
The project uses the following:
 - Java
 - Maven (Maven is used to define project structure, dependencies, build, and test management.)
 - Selenium WebDriver (Selenium is used to perfom Web/UI testing)
 - JUnit
 - Jetty & Glassfis (For Api Testing)


Executing tests
---
To facilitate the use of this project, there will be one or more executable files that can help to perfom several tasks.

**Testing**
To start a test manually follow this indications:
  Before start testing
  - Maven should be installed before executing the test.
  - The Chrome Driver should be updated (Check documentation folder for info)

  Starting
  1) Open a CMD 
  2) In the console go to "Project\AutomaticTestForDemo" inside this folders
  3) Execute the command "mvn test", this will trigger the test. If dependencies are needed, they will be downloaded before the test.
