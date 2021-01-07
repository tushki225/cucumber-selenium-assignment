## Table of contents
* General info
* Tools and Technologies
* Setup
* Execution

## General info
This project is designed for the verification of Egg Timer website http://e.ggtimer.com/
	
## Tools and Technologies
Project is created with:
* Selenium Standalone v3.141
* Cucumber v1.2.2
* Gherkin v1.2.2
* Cucumber v2.12.2
* Junit v4.11
* chromedriver v87.0 (Please make sure that chrome v87.0 is installed on your machine)
* Make sure to install following plugins from Eclipse marketplace - Cucumber Eclipse and Natural.

	
## Setup
1. Clone the repository in eclipse with master branch as- https://github.com/tushki225/cucumber-selenium-maersk-assignment.git
2. Add all jar files available in libraries folder to build path of project using below steps

		* Right click project-->Select Build Path--> Configure Build Path
		* Move to Libraries tab, click Classpath and then click Add Jars button
		* Then Select all jars available in libraries folder- cucumber and selenium folder
		* Apply and Close. Then 
		
3. Now, Build and Clean Project.	


## Execution
To run this project-

1. Right click Runner.java file(Project folder-->src-->TestRunner-->Runner.java) and select Run As->JUnit Test.	
2. Observe the execution in Junit View from Eclipse
3. Reports will be generated at the location- Project folder-->target-->cucumber-reports

For issues, please drop a mail to cooltushki@gmail.com
