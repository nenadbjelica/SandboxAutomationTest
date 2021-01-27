Sendbox maven project is implemented in Eclipce using Java 13, Selenium 3.141.59 and Chrome driver 86. 
In order to run tests chrome browser must have version 86.
To run all tests we need to open tests.xml file (src\test\resources) and right click Run As -> TestNG Suite. Of course, tests can be run one by one.
To distinguish what was created by Selenium and what with JMeter, I added ".java" next to the text (e.g. Selenium.java) and for JMeter ".jmx" (e.g. Selenium.jmx)
After running tests, Sendbox folder will be created with sub folders Log and Screenshots (C:\Sendbox\Logs ; C:\Sendbox\Screenshots). There is log file and screenshots if something failed.

Note: Playground form (https://qa-sandbox.apps.htec.rs/projects) is intentionally left empty (nothing created) and after starting the tests everything will be created (what, explained in use cases). 
Note: Use cases are already created and nothing bothers to stay like that because the same use cases will be created after starting tests (or we can remove all use cases from UI and run automation tests).