# SysdigMonitor


### Since there is no information about the requirements, I created the test cases according to the current behavior of the application.

I have developed the framework based on Page Object Model and Java is programming language. 
I created framework structure by using Maven pom.xml file.
I used SELENIUM and CUCUMBER test automation tools. 
It is a BDD(Behavior Driven Development) framework and it also supports Data Driven Testing by using Scenario Outline.
I defined my test steps with a simple English by using Gherkin language key words in feature files. 
I provided implementation for each step which defined inside Feature File inside StepDefinition class.
I performed validation using JUnit assertions.
I added maven-cucumber-reporting plugin to generate Cucumber reports after test execution with maven comands. 
Also I added rerun plugin inside TestRunner.java Cucumber options to store failed test cases in a txt file.
I created the FailedRunner.java class to be able to execute failed test cases separately.


### Structure of the framework

- _pages/ - Each Page in the application related to test cases has a corresponding Page Object class
- _runners/ - Execute process
- _stepDefinitions/LoginPageSteps.java - Library of annotated Java methods that linked to each step in feature file.
- _stepDefinitions/Hooks.java-  @Before - @After annotations to gather all common setup and teardown requirements for the each scenario.
- _utilities/CommonMethods.java - Reusable methods
- _utilities/ConfigFileReader.java - Read data from Configuration.properties file
- _utilities/Constants.java - Final variables
- _utilities/Driver.java - Singleton Design Pattern, WebDriver initialization, WebDriver teardown
- _resources/features/ - scenarios or scenario outlines that describes test steps
- _resources/Configuration.properties - Some common data


Since shadow root is not created open I didn't able to get text from error messages to perform assertions to automate invalid email id scenarios so I manually tested them. The dynamics of the error messages is very impressive. It would be great to try many scenarios with automation. 

I left a comment on the scenarios in the feature file about the findings that can be considered defect.


### Suggession
While authenticating with google, the system automatically detects the google account logged in. 
If this is not a bussines requirement, the user may be asked with which google account they want to log in.




