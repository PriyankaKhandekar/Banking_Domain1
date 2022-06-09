package TestClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import BaseClasses.Base_Class;
import PomClasses.Home_Page;
import PomClasses.Login_Page;

public class VerifyUserCanAddFundToAccount {

	WebDriver driver;
	Login_Page lp;
	Home_Page hp;
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser)
	{		
		driver = Base_Class.getDriver(browser);
	}
	@BeforeMethod
	public void beforeMethod() 
	{
		lp = new Login_Page(driver);
		hp = new Home_Page(driver);
	}
	@Test
	public void verifyUserCanLogin() throws IOException, InterruptedException
	{
		lp.clickResister();
		lp.enterEmailId();
		lp.clickOnBtn();
		lp.enterPasswrd();
		lp.clickOnBtn1();
		lp.enterPIN();
		
		hp.clickOnProfile();
		Assert.assertTrue(hp.verifyUser());
		
	}
	@Test(priority=2)
	public void veridyUserCanOpenFundWindowOnClikingFundButton()
	{
		hp.clickmutualFundBtn();
		hp.verifyUserCanClickOnFund();
	}
	@AfterClass
	public void afterClass()
	{
		
	}
	@AfterMethod
	public void afterMethod()
	{
		
	}

}
