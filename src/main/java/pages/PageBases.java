package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class PageBases {

	
	
	// create a constructor to initialise the driver
	public PageBases(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	protected static  WebDriver driver ;  

	protected static void clickButton(WebElement button) 
	{
		
		button.click();
	}

	protected static void setTextElementText(WebElement textElement , String value) 
	{
		textElement.sendKeys(value);
	}
	
	

}
