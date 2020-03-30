package test;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;

public class NameValidationTest extends TestBase {
	Faker fakeData=new Faker();
	SignUpPage signUpPageObject;
	HomePage homePAgeObject;
	LoginPage loginPageObject;
	
	String firstName = fakeData.name().firstName().toLowerCase();
	String lastName = fakeData.name().lastName().toLowerCase();
	String email = fakeData.internet().emailAddress(); 
	String phone = fakeData.number().digits(11).toString();
	String password = fakeData.number().digits(8).toString();

	

	@Test( alwaysRun = true)
	public void validateName(Method method) throws InterruptedException {
		
		driver.navigate().to(URL);
		
		signUpPageObject=new SignUpPage(driver);
		
		signUpPageObject.signUpSteps(firstName.toLowerCase(),lastName.toLowerCase(),phone,email,password,password);
		
		Assert.assertEquals(signUpPageObject.welcomeStatment.isDisplayed(), false);
		System.out.println(signUpPageObject.firstNameEditBox.isDisplayed());
		
	}
	
	
	
	
	
	
	
}
