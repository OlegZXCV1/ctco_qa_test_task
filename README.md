
# Technical task:
Create a maven project that contains one test.
Test should be executed by
'mvn clean test' command.

# Test should do following:
* 1 Log in to https://ctco.lv/en page 
* 2 Open Careers menu
* 3 Click Vacancies from the list
* 4 Open vacancy with title "Test Automation Engineer"
* 5 Verify exact count of skills under the paragraph "Professional skills and
qualification"


### USE: Selenide + Allure + JUnit5 

## To run tests:

* run `mvn clean test`

## To see Allure report:

1. run `mvn allure:serve`
2. it will automatically open `http://localhost:8080` in your browser
