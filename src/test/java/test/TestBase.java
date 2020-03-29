package test;


import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.Helper;

public class TestBase {
	
public static WebDriver driver ; 
public static ExtentReports extent;
public static ExtentTest logger;

//This is the method of firing the browser if it is chrome , firefox or ie
	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browserName) throws InterruptedException 
	{
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver = new ChromeDriver(); 
		}

		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			driver = new FirefoxDriver(); 
		}

		else if (browserName.equalsIgnoreCase("ie")) 
		{
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/drivers/IEDriverServer.exe");
			driver = new InternetExplorerDriver(); 
		}

		else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver(); 
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.navigate().to("https://www.phptravels.net/register");
		
		//set the extent report in the destination
		extent=new ExtentReports("C:\\Users\\melbatawy\\Documents\\applicationTask\\Reports\\Report.html",true);
		
		
	} 

	
		
	@BeforeMethod
	public void report(Method method) {
		
		logger=extent.startTest(method.getName());
	}

	// take screenshot when test case fail and add it in the Screenshot folder
	@AfterMethod
	public void prepareReport(ITestResult result) 
	{
		
		if(result.getStatus()==ITestResult.SUCCESS) { 
			logger.log(LogStatus.PASS, "Test Cass pass");
		}
		
		else if (result.getStatus() == ITestResult.FAILURE)
		{
			//Adding image if the TC failed
			logger.log(LogStatus.FAIL, "Test Case Fail","<a href='" + result.getName() + ".png" + "'><span class='label info'> ScreenShot URL</span></a>");
			System.out.println("Failed!");
			System.out.println("Taking Screenshot....");
			Helper.captureScreenshot(driver, result.getName());
		}
		
		else {
			logger.log(LogStatus.SKIP, "Test Case Skipped");
		}
		
		
	}
	
	//This method to quote from the browser after running the all TCs
		@AfterSuite
		public void stopDriver() 
		{
		    
			driver.quit();
			extent.flush();
		}


}
