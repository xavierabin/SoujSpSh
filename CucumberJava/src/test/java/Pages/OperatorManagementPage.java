package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.testng.asserts.SoftAssert;

public class OperatorManagementPage {

	WebDriver driver;
	
	By txt_firstname = By.id("tbSearch0_1");
	By txt_lastname = By.id("tbSearch0_2");
	By txt_personnelnumber = By.id("tbPersonnelNumber");
	By txt_cardnumber = By.id("tbSearch0_3");
	By txt_facilitycode = By.id("tbSearch0_4");
	By txt_accesstype = By.id("tbSearch0_5");
	By lnk_firstFilteredOperator=By.xpath("//table[@id=\"tblDataTable0\"]");
	By btn_updateOperatorDetails = By.id("btnUpdateOperatorDetails");
	By txt_updatesuccessMsg = By.id("pStatusOperaterDetails");
	By btn_updateProceed = By.id("btnUpdateYes");			
	SoftAssert softAssert = new SoftAssert();
	public OperatorManagementPage(WebDriver driver)

	{
		this.driver=driver;
		
	}
	
	public void searchByFirstName(String firstname)
	{
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(txt_firstname).sendKeys(firstname);
		driver.findElement(txt_firstname).sendKeys(Keys.RETURN);
	}
	
	public void searchByLastName(String lastname)
	{
		driver.findElement(txt_lastname).sendKeys(lastname);
		driver.findElement(txt_lastname).sendKeys(Keys.RETURN);
	}
	
	public void searchByCardNumber(int cardnumber)
	{
		driver.findElement(txt_cardnumber).sendKeys(String.valueOf(cardnumber));
		driver.findElement(txt_lastname).sendKeys(Keys.RETURN);
	}
	
	public void searchByFacilityCode(int facilitycode)
	{
		driver.findElement(txt_facilitycode).sendKeys(String.valueOf(facilitycode));	
	}
	
	public void searchByAccessType(String accesstype)
	{
		driver.findElement(txt_accesstype).sendKeys(accesstype);	
	}
	
public void selectFirstOperator()
{
	driver.findElement(lnk_firstFilteredOperator).click();
	driver.findElement(lnk_firstFilteredOperator).click();
}

	public void enterPersonnelNumber(int personnelNo)
	{
		driver.findElement(txt_personnelnumber).clear();
		driver.findElement(txt_personnelnumber).sendKeys(String.valueOf(personnelNo));
	}
	public void clickUpdateOperatorDetails()
	{
	driver.findElement(btn_updateOperatorDetails).click();
	if(driver.findElement(btn_updateProceed).isDisplayed())
	{
		driver.findElement(btn_updateProceed).click();
	}
	}
public void verifyUpdateSuccessMsg()
{
	try {
	softAssert.assertEquals(driver.findElement(txt_updatesuccessMsg).isDisplayed(), true);	
	}
	catch (Exception e)
	{
		System.out.println(e);
	}
}
}
