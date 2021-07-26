package StepDefinitions;

import java.io.File;
import java.io.IOException;

//import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import Pages.LoginPage;
/*import io.cucumber.java.After;
import io.cucumber.java.Before; */
import io.cucumber.java.en.*;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.TakesScreenshot;

//import java.lang.System;;


public class SpeedShieldLoginSteps {
	
	//WebDriver driver;
	ChromeOptions options = new ChromeOptions();	
	HtmlUnitDriver driver = new HtmlUnitDriver(true);
	SoftAssert softAssert = new SoftAssert();
	LoginPage loginpage;
	
	String userDirectoryPath=System.getProperty("user.dir");
	
	File DestFile;
//@Before
public SpeedShieldLoginSteps()
{
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/drivers/chromedriver");
	options.addArguments("headless");
	//driver= new ChromeDriver(options);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	driver.manage().window().maximize();
}


@Given("user is on login page")
	public void user_is_on_login_page() {
	
		loginpage=new LoginPage(driver);
		loginpage.openFleetOnlineApp();	   
		
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String username, String password) {
	  
		   loginpage.enterUsername(username);
		   loginpage.enterPassword(password);
	}

	@When("click on login button")
	public void click_on_login_button() {
		loginpage.clickLogin();
		
	}

	@Then("user is navigated to FleetOnline Operator Management page")
	public void user_is_navigated_to_fleet_online_operator_management_page() throws IOException {
	    
		System.out.println("User is navigated to FleetOnline Operator Management Page"); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
    /*   assertEquals(driver.getTitle(), "Fleet Online");
		TakesScreenshot Ts =((TakesScreenshot)driver);
		File ScreenshotsFile =  Ts.getScreenshotAs(OutputType.FILE);
		DestFile=new File(userDirectoryPath+"TestScreenshots/LoginSuccessOperatorsPage.jpg");
		FileUtils.copyFile(ScreenshotsFile,DestFile);
		*/
		
		softAssert.assertEquals(driver.getTitle(), "Fleet Online");
		driver.quit();
	}
	
	@When("user click on Reset Password link")
	public void user_click_on_Reset_Password_Link()
	{
		loginpage.clickResetPassword();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	}
	@Then("user is navigated to Reset password page")
	public void verify_user_is_navigated_to_Reset_password_page() throws IOException
	{
		/*TakesScreenshot Ts =((TakesScreenshot)driver);
		File ScreenshotsFile =  Ts.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(userDirectoryPath+"TestScreenshots/ResetPasswordPage.jpg");
		FileUtils.copyFile(ScreenshotsFile,DestFile);
		*/
		try {
         
		softAssert.assertEquals(driver.findElement(By.xpath("//h2[contains(.,'Reset your password')]")).isDisplayed(), true);	
		}catch ( Exception e)
		{
			System.out.println(e);
			
		}
		driver.quit();
		
	}

	/*@After
	void teardown()
	{
	driver.close();
	driver.quit();
	System.out.println("Inside TearDown in Loginsteps");
	}
	from git
	*/
	
}
