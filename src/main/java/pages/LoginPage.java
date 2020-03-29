package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBases {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@name='username']")
	WebElement emailEditBox;


	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordEditBox;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-lg btn-block loginbtn']")
	WebElement logInButton;

	@FindBy(xpath = "//a[@class='btn btn-success br25 btn-block form-group']")
	WebElement RegisterButton;


	public void logIn(String email,String password) {

		setTextElementText(emailEditBox, email);
		setTextElementText(passwordEditBox, password);
		clickButton(logInButton);

	}

	public void RegisterButtonClick() {
		clickButton(RegisterButton);

	}



}
