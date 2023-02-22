package Base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base
{
	public static WebDriver driver;
	public static Properties prop;

	public void driverSetup()
	{
		prop = new Properties();
		System.setProperty("webdriver.chrome.driver", "C:\\Jar new\\chromedriver_win32\\chromedriver.exe");
		try 
		{
			prop.load(new FileInputStream("C:\\Users\\MY LAPTOP\\eclipse-workspace\\SearchForSchools\\src\\Config\\config.properties"));
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		if (prop.getProperty("browserName").matches("chrome")) 
		{
			driver = new ChromeDriver();
		}
		if (prop.getProperty("browserName").matches("firefox"))
		{
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	public void closeBrowser() {
		driver.quit();
	}
}

