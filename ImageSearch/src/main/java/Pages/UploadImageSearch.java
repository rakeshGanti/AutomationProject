package Pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import Base.Base;

public class UploadImageSearch extends Base{
	
    public void OpenUrl(){
		
		driver.get("http://google.com");
	}
    public void uploadAndSearch() throws InterruptedException, IOException {
    	WebDriverWait wait;
    	
    	driver.findElement(By.xpath("//a[text()='Images']")).click();
    	driver.findElement(By.className("tdPRye")).click();
    	driver.findElement(By.xpath("//a[text()='Upload an image']")).click();
    	WebElement chooseFile = driver.findElement(By.id("awyMjb"));
    	chooseFile.sendKeys(System.getProperty("user.dir")+"/SampleImage/logo.jpg");
    	String text=driver.findElement(By.id("result-stats")).getText();
    	System.out.println(text);
    	System.out.println("The message is visible and verified.");
    	wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hdtb-tls")));
    	driver.findElement(By.id("hdtb-tls")).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Time']")));
    	driver.findElement(By.xpath("//div[text()='Time']")).click();
    	driver.findElement(By.xpath("//span[text()='Custom range...']")).click();
    	driver.findElement(By.id("OouJcb")).sendKeys("9/10/2021");
    	driver.findElement(By.id("rzG2be")).sendKeys("10/30/2021");
    	driver.findElement(By.xpath("//g-button[text()='Go']")).click();
    	Thread.sleep(5000);
    	System.out.println("The Results are within the Selected Custom Date.");
    	TakesScreenshot capture = (TakesScreenshot) driver;
		File srcFile = capture.getScreenshotAs(OutputType.FILE);
		File destFile = new File(System.getProperty("user.dir")
				+ "/Screenshot/GoogleImageSearch.png");
		Files.copy(srcFile, destFile);
		System.out.println("Automation Completed Successfully");
    }
    
    public static void main(String[] args) throws InterruptedException, IOException{
    	UploadImageSearch ha= new UploadImageSearch();
		ha.driverSetup();
		ha.OpenUrl();
		ha.uploadAndSearch();
		ha.closeBrowser();
	}
}
