package test;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.Loadproperties;
import pages.SignUpPage;

public class MailValidationTest extends TestBase{
	SignUpPage signUpPageObject;
	String logoutURL=Loadproperties.userData.getProperty("logoutURL");
	String firstName=Loadproperties.userData.getProperty("firstName");
	String lastName=Loadproperties.userData.getProperty("lastName");
	String phone=Loadproperties.userData.getProperty("phone");
	String email=Loadproperties.userData.getProperty("email");
	String password=Loadproperties.userData.getProperty("password");
	
	@Test(alwaysRun = true)
	public void validateEmail(Method method) throws InterruptedException {
		driver.navigate().to(logoutURL);
		
		driver.navigate().to(URL);
		
		signUpPageObject=new SignUpPage(driver);
		
		signUpPageObject.signUpSteps(firstName,lastName,phone,email,password,password);
		Assert.assertEquals("Email Already Exists.", signUpPageObject.errorMessage.getText());
		System.out.println(signUpPageObject.errorMessage.getText());
}

}
