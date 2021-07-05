# RestAssuredApiTesting
Project Title: Automation of api http://api.citybik.es/v2/networks

Motivation: As a biker I would like to know the exact location of city bikes around the world in a given application.

Design:

Framework : BDD Approach using Cucumber and Junit

Testing Framework: Test scripts are developed using Java, Restassured, Cucumber and Junit. 

    Runner : Class to drive the test scripts from configured feature file
    Feature : File describes the scenario of the api testing in Gherkin language
    Step Definitions: Class that has the definitions of each step of the scenario (Get Base Url, Hit the url with Get Request, Validate the country, latitude and longitude)

Report and Logging: Logging are performed using log4j capturing debug and info level logs for debugging purpose. Reports are configured using Json-reports

Utility: Utility Modules contains resuable files like Properties files configuration and constants.

Build Tool: Maven is used to build the project using POM.xml and also add the project dependencies.

Version Control System: The project is maintained in GitHub for versioning and updating the future changes.

Steps to execute:
  
    1.Open Command prompt
    2.Move to the project folder
    3.Execute test using mvn clean test
 
