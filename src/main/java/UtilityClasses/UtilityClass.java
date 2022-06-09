package UtilityClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtilityClass {
	WebDriver driver;
	public static void getScreenshot(WebDriver driver,String testName)
	{
		Date date = new Date();
		SimpleDateFormat f = new SimpleDateFormat("YYYY-MM-dd-hh-mm-ss");
		String currentDate = f.format(date);
		
		File sourse = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = testName +".png";
		File dest = new File(path);
	}
	
	public static WebElement explicitlyWait(WebDriver driver , WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		WebElement element1 = wait.until(ExpectedConditions.visibilityOf(element));
		return element1;
	}
	
	
	public static String getDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream file = new FileInputStream("Configuration//Config.properties");
		Properties prop = new Properties();
		prop.load(file);
		
		return prop.getProperty(key);
	}

}
