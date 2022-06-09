package PomClasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.UtilityClass;

public class Home_Page extends UtilityClass{

	WebDriver driver;

	@FindBy(xpath="//div[@class='valign-wrapper']")
	private WebElement profileIcon;
	
	@FindBy(xpath="//p[@class='truncate headerDggnd']")
	private WebElement profileEmail;
	
	@FindBy(xpath="//div[text()='Mutual Funds']")
	private WebElement mutualFundBtn;
	
	@FindBy(xpath="//span[text()='EXPLORE MUTUAL FUNDS']")
	private WebElement exploremutualFundBtn;
	
	public Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void clickOnProfile()
	{
		explicitlyWait(driver,profileIcon);
		profileIcon.click();
	}
	public boolean verifyUser() throws IOException
	{
		explicitlyWait(driver,profileEmail);
		String emailFromUI = profileEmail.getText();
		String emailFromConfig = getDataFromPropertyFile("emailId");
		
		if(emailFromUI.equals(emailFromConfig))
		{
		return true;
		}
		return false;
	}
	public void clickmutualFundBtn()
	{
		explicitlyWait(driver,mutualFundBtn);
		mutualFundBtn.click();
	}
	public boolean verifyUserCanClickOnFund()
	{
		explicitlyWait(driver,exploremutualFundBtn);
		if(exploremutualFundBtn.isDisplayed())
		{
		return true;
		}
		return false;
	}
	
	
}
