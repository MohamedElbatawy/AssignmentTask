package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBases {

	public HomePage(WebDriver driver) {
		super(driver);
		
	}

		
		@FindBy(xpath = "(//a[@class='btn btn-text-inherit btn-interactive'])[3]")
		WebElement multyChoice;
		
		@FindBy(xpath = "//a[@class='dropdown-item tr']")
		WebElement logout;
		
		
		
		
		public void logOutFromAccount() {
			clickButton(multyChoice);
			clickButton(logout);
		}
}
