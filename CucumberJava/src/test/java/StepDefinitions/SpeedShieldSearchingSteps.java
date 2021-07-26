package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import Pages.LoginPage;
import Pages.OperatorManagementPage;
/*import io.cucumber.java.After;
import io.cucumber.java.Before;*/
import io.cucumber.java.en.*;
import org.testng.asserts.SoftAssert;
//import org.openqa.selenium.Keys;
public class SpeedShieldSearchingSteps {

	OperatorManagementPage operatormngPage;
	//WebDriver driver;
	ChromeOptions options = new ChromeOptions();	
	  HtmlUnitDriver driver = new HtmlUnitDriver(true);
	
	
	SoftAssert softAssert = new SoftAssert();
	OperatorManagementPage operatorManagementPage;
	public SpeedShieldSearchingSteps()
	{
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/drivers/chromedriver");
		options.addArguments("headless");
		//driver= new ChromeDriver(options);
		//System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
		//WebDriver driver = new PhantomJSDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
@Given("user is on Operator Management Page")
public void user_is_on_operator_management_page_for_given_test_sst_com_and_pass123() 
{
	LoginPage loginpage;

	loginpage=new LoginPage(driver);
	loginpage.openFleetOnlineApp();
	loginpage.enterUsername("test_141@sst.com");
	loginpage.enterPassword("Pass123!");
	loginpage.clickLogin();
	operatorManagementPage = new OperatorManagementPage(driver);
			softAssert.assertEquals(driver.getTitle(), "Fleet Online");
			 System.out.println(" User is now on Operator Management Page"); 

	
}

@When("user enter (.*) and (.*)")
public void user_enter_operator_and_card1236() {
	operatorManagementPage.searchByFirstName("Operator");
	operatorManagementPage.searchByLastName("Card1236");
	System.out.println("User is entering Operator and Lastname values"); 

}

@Then("the grid applies the filters")
public void the_grid_applies_the_filters() {
	System.out.println("the grid applies the filters"); 
	
}

@And("update {int} and click Update Operator details")
public void update_and_click_update_operator_details(int PersonnalNumber) {
	System.out.println("user is updating Personnel number"); 
	operatorManagementPage.selectFirstOperator();
	operatorManagementPage.enterPersonnelNumber(PersonnalNumber);
	operatorManagementPage.clickUpdateOperatorDetails();
}

@Then("update success notification is received")
public void update_success_notification_is_received() {
	operatorManagementPage.verifyUpdateSuccessMsg();
	System.out.println("Success Message is received"); 
}
	
}
