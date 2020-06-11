package Testng_demo.Testng_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login_testcase2 {
	WebDriver driver=null;
	//WebDriverWait wait = new WebDriverWait(driver, 30);
@BeforeSuite
public void launchbrowser() {
WebDriverManager.chromedriver().setup();
//driver=new ChromeDriver();
}
@BeforeMethod
public void launchurl() throws Exception {
	
	driver=new ChromeDriver();
	driver.get("https://qa-tekarch.firebaseapp.com/");	
	
	driver.manage().window().maximize();
Thread.sleep(3000);
}

@Test
public void invalidlogincredentials() throws Exception{
	driver.findElement(By.id("email_field")).sendKeys("admin123@gmail.com");
		
		driver.findElement(By.xpath("//input[@placeholder='Password...']")).sendKeys("admin12");
		driver.findElement(By.xpath("//button[contains(text(),'Login to Account')]")).click();
		WebDriverWait	 wait = new WebDriverWait(Browser_utilities.driver, 30);
		wait.until(ExpectedConditions.visibilityOf(Browser_utilities.driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"))));	
			
		
		//Thread.sleep(4000);	
}

@Test
public void validlogincredentials() throws Exception{
	driver.findElement(By.id("email_field")).sendKeys("admin123@gmail.com");
		
		driver.findElement(By.xpath("//input[@placeholder='Password...']")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[contains(text(),'Login to Account')]")).click();	
		WebDriverWait	 wait = new WebDriverWait(Browser_utilities.driver, 30);
		wait.until(ExpectedConditions.visibilityOf(Browser_utilities.driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"))));	
		
		Thread.sleep(4000);	
}

@AfterMethod
public void settingURL() {
	if(Browser_utilities.driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).isDisplayed())
	{
		Browser_utilities.driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		// wait = new WebDriverWait(Browser_utilities.driver, 30);
		//wait.until(ExpectedConditions.visibilityOf(Browser_utilities.driver.findElement(By.id("email_field"))));	
	}}
@AfterSuite
public void quit() {
driver.quit();	
}
}

