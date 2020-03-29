package test;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.Loadproperties;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;

public class FailedRegisteration extends TestBase {
	SignUpPage signUpPageObject;
	HomePage homePAgeObject;
	LoginPage loginPageObject;

	String firstName=Loadproperties.userData.getProperty("firstName");
	String lastName=Loadproperties.userData.getProperty("lastName");
	String phone=Loadproperties.userData.getProperty("phone");
	String email=Loadproperties.userData.getProperty("email");
	String password=Loadproperties.userData.getProperty("password");
	String passwordConfirmation=Loadproperties.userData.getProperty("password");

	@Test(priority = 1, alwaysRun = true)
	public void signUpProcess(Method method) throws InterruptedException {

		signUpPageObject=new SignUpPage(driver);
		signUpPageObject.signUpSteps(firstName,lastName,phone,email,password,passwordConfirmation);
		Assert.assertEquals("Hi,"+" "+firstName+" "+lastName, signUpPageObject.welcomeStatment.getText());
		System.out.println(signUpPageObject.welcomeStatment.getText());
	}
	
	@Test(dependsOnMethods = {"signUpProcess"})
	public void logOut(Method method) {
		homePAgeObject=new HomePage(driver);
		homePAgeObject.logOutFromAccount();
		loginPageObject=new LoginPage(driver);
		loginPageObject.RegisterButtonClick();
		
	}

	
	@Test(priority = 2)
	public void failedRegisteration(Method method) throws InterruptedException {

		signUpPageObject=new SignUpPage(driver);
		signUpPageObject.signUpSteps(firstName,lastName,phone,email,password,passwordConfirmation);
		Assert.assertEquals("Hi,"+" "+firstName+" "+lastName, signUpPageObject.welcomeStatment.getText());
		System.out.println(signUpPageObject.welcomeStatment.getText());
	}

}
