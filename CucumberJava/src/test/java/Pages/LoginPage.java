package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {

	WebDriver driver;
	
	By txt_username = By.id("tbUsername");	
	By txt_password = By.id("tbPassword");
	By btn_forlogin = By.id("btnSignIn");
	By lnk_resetPassword = By.id("lnkForgotPassword");
	By btn_acceptCookies = By.id("okBtn");

	
	public LoginPage(WebDriver driver)
	{
		
		this.driver=driver;
	}
	
 public void openFleetOnlineApp()
 {
	 driver.navigate().to("https://staging.fleetonline.net");
	 
 }
	
	public void enterUsername (String username)
	{
		driver.findElement(txt_username).sendKeys(username);
		
	}
	
	public void enterPassword (String password)
	{
		driver.findElement(txt_password).sendKeys(password);
		
	}	
	
	public void clickLogin()
	{
		try {
			if(driver.findElement(btn_acceptCookies).isDisplayed())
			{
				driver.findElement(btn_acceptCookies).click();
				
			}
		driver.findElement(btn_forlogin).click();
		} catch (Exception e)
		{
			  System.out.println(e);
			 
	}
	
	}public void clickResetPassword()
		{
			try
			{
				if(driver.findElement(btn_acceptCookies).isDisplayed())
				{
					driver.findElement(btn_acceptCookies).click();
					
				}
				driver.findElement(lnk_resetPassword).click();
				
			}catch (Exception e)
			{
				System.out.println(e);
			
			}
		}


}
