package PomClasses;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import UtilityClasses.UtilityClass;

public class Login_Page extends UtilityClass{

	WebDriver driver;
	@FindBy(xpath="//span[text()='Login/Register']")
	private WebElement registration;

	@FindBy(xpath="//input[@id='login_email1']")
	private WebElement enterEmail;
	
	@FindBy(xpath="//span[text()='Continue']")
	private WebElement enterBtn;
	
	@FindBy(xpath="//input[@id='login_password1']")
	private WebElement enterPassward;
	
	@FindBy(xpath="//span[text()='Submit']")
	private WebElement enterBtn1;
	
	@FindBy(xpath="(//input[@class='otpinput88'])[1]")
	private WebElement enterOTP;
	
	public Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver = driver;
	}
	
	public void clickResister()
	{
		registration.click();
	}
	public void enterEmailId() throws IOException
	{
		explicitlyWait(driver,enterEmail);
		enterEmail.sendKeys(getDataFromPropertyFile("emailId"));
	}
	public void clickOnBtn()
	{
		enterBtn.click();
	}
	public void enterPasswrd() throws IOException
	{
		explicitlyWait(driver,enterPassward);
		enterPassward.sendKeys(getDataFromPropertyFile("passward"));
	}
	public void clickOnBtn1()
	{
		enterBtn1.click();
	}
	
	
	public void enterPIN() throws IOException, InterruptedException
	{
			String pin = getDataFromPropertyFile("pin");
			char[] digit = pin.toCharArray();
			
			explicitlyWait(driver, enterOTP);
		
			
			List<WebElement> list = driver.findElements(By.xpath("//input[@class='otpinput88']"));
			
			//(//input[@class='otpinput88'])[1]
			
			//pin1.sendKeys(pin);
			
			for(int i=0;i<list.size();i++)
			{
				list.get(i).sendKeys(String.valueOf(digit[i]));
				Thread.sleep(1000);
			}
		}
		
	}
	
