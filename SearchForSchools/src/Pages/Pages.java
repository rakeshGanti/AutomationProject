package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Base;

public class Pages extends Base
{
	WebDriverWait wait;
	public void openUrl()
	{
		driver.get("https://www.eduvidya.com");
	}
	
	public void school() 
	{ 
		driver.findElement(By.xpath("//a[text()='Schools']")).click();
	}
	
	
	public void error() throws AWTException {

		Robot robot = new Robot();
		robot.mouseMove(700, 700);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void courses() throws InterruptedException 
	{
		wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ddl_Category\"]")));
		WebElement ddown = driver.findElement(By.xpath("//*[@id=\"ddl_Category\"]"));
		Select select = new Select(ddown);
		select.selectByVisibleText("CBSE");
		Thread.sleep(2000);
	}
	
	public void city()
	{
		WebElement ddown2 = driver.findElement(By.xpath("//*[@id=\"ddl_City\"]"));
		Select select2 = new Select(ddown2);
		select2.selectByVisibleText("Pune");		
	}
	
	public void button() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"btnSearch\"]")).click();
		Thread.sleep(2000);
	}
	public void verify()
	{
		System.out.println("The schools are:");
		List<WebElement> names = driver.findElements(By.xpath("//*[@id=\"pnllist\"]/div[2]/ul/li/div[2]/a"));
		for(int i=0 ;i<names.size();i++){
		   System.out.println(names.get(i).getText());
		}
		WebElement list = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[1]/div[1]/a"));
		if (list.isDisplayed()) 
		{
			System.out.println(" schools found with the given data");
		} 
		else			
			System.out.println(" schools  not found with the given data"); // IF NO SEARCH RESULTS ARE FOUND
	}
	
	public static void main(String[] args) throws InterruptedException, IOException, AWTException{
		Pages obj = new Pages();
		obj.driverSetup();
		obj.openUrl();
		obj.school();
		obj.error();
		obj.courses();
		obj.city();
		obj.button();
		obj.verify();
		obj.closeBrowser();
	}

}

