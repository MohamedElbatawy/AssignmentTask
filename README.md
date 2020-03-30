"# AssignmentTask" 
Task
•	Summary : 
	This is developing of some TCs of registration process and some validation on Website using selenium java with maven frame work.
	In this project we use 2 methods for data provider one for data configuration file the second is for java faker class.
•	Project packages: 
1.	Pages: Contains all pages classes 
2.	Tests: contain all test classes
3.	Utilities: Contain all classes that can help in Testing report
4.	Properties: Contain Configuration file of the Test Data
5.	Data : Contain Class to load the data from the file configuration 

•	Package classes:

	Pages
1.	Page Base: 
A.	That contain all method to implement actions on the element as click on button and send keys that only need to calling on each page classes
B.	Contain Page Factory method to initialize all elements in all classes that inherited the Page Base 
2.	RegisterationPage:
A.	Contain all Element that displayed in Registers page containing fields and button
B.	Contain the method of taking action on the element into the classes 
3.	HomePage:
A.	contain all element selector that displayed in home page after registeration.
B.	This Element which related to logout
C.	Contain method to logout from the account
4.	LoginPage: 
A.	Contain all element and method that implement login edit texts and fields 
B.	Contain method of login process

	Tests

1.	Test Base: 
A.	That contain all basis that need to navigate to the registration page that contain firing the browser with set chrome as default browser.
B.	Contain the method of start and end browser session
C.	Contains “ExtentReport” default setting as Destination and cases that TCs can be fall in it ex: Fail ,Skipped and success
2.	RegisterTest
A.	Contain method that call method from registerPage
3.	EmailValidationTest
A.	Contain 1 method to be tested for validate on used email before (expected: success )
4.	LoginTest
A.	Contain 3 method to be tested one for register the second for logout that the third for login that called from LoginPage, RegisterPage and HomePage (expected: success )
5.	NameValidationTest
A.	This is to test that names should start with upper letter (expected: failed)


	Properties
1.	Contain Data configuration file for test Data
	Data
1.	Contain class to load data from configuration file 
•	The project contain “Report” folder for extent report and screenshot if test case is failed 
•	The Project contain “Driver” folder for different driver as chrome,…
•	The Project contain “pom.xml” file that contain dependency for different features in project

•	How the program run ? : from “test” xml file you can run the test as first registration should done then logout then registration start then logout then login after that validation on email and name should be started

•	Finally, for “HTTP interceptor” I am gaining knowledge for it so it is missed from the development I will learn it isA.



