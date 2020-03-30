package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends PageBases {

	//create a constructor to initialise the driver
	public SignUpPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@name='firstname']")
	public WebElement firstNameEditBox;
	
	@FindBy(xpath = "//input[@name='lastname']")
	WebElement lastNameEditBox;
	
	@FindBy(xpath = "//input[@name='phone']")
	WebElement mobileNumberEditBox;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement emailEditBox;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordEditBox;
	
	@FindBy(xpath = "//input[@name='confirmpassword']")
	WebElement confirmPasswordEditBox;
	
	@FindBy(xpath = "//button[contains(text(),'Sign Up')]")
	WebElement signUpButton;
	
	@FindBy(xpath = "//div[@class='alert alert-danger']")
	public WebElement errorMessage;
	
	@FindBy(xpath = "//h3[@class='text-align-left']")
	public WebElement welcomeStatment;
	
	
	public void signUpSteps(String userFirstName,String userlastName,String userphone,String useremail,String userpassword,String userPasswordConfirmation) throws InterruptedException
	{
		setTextElementText(firstNameEditBox, userFirstName);
		setTextElementText(lastNameEditBox, userlastName);
		setTextElementText(mobileNumberEditBox, userphone);
		setTextElementText(emailEditBox, useremail);
		setTextElementText(passwordEditBox, userpassword);
		setTextElementText(confirmPasswordEditBox, userPasswordConfirmation);
		confirmPasswordEditBox.sendKeys(Keys.ENTER);
		
		
	}
	

}
