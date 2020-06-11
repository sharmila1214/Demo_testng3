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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Data_provider_practice {
	WebDriver driver=null;
	@BeforeSuite
	public void launchbrowser() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
driver.manage().window().maximize();
	}
	@BeforeMethod
	public void launchurl() throws Exception {	
		driver.get("https://qa-tekarch.firebaseapp.com/");	
	}
	@Test(dataProvider="logininfo")
	public void logincredentials(String username,String password) throws Exception{
		driver.findElement(By.id("email_field")).sendKeys(username);
			
			driver.findElement(By.xpath("//input[@placeholder='Password...']")).sendKeys(password);
			driver.findElement(By.xpath("//button[contains(text(),'Login to Account')]")).click();
			WebDriverWait	 wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"))));	
	//Thread.sleep(4000);
	}
	@AfterMethod
	public void settingURL() {	
		if(driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).isDisplayed())
		{
			driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		//WebDriverWait wait = new WebDriverWait(Browser_utilities.driver, 30);
		//	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email_field"))));	
		}
	
	}
	
	@DataProvider(name ="logininfo")
	Object[][] passingcredentials(){
		return new Object[][] {{"admin123@gmail.com","admin123"},{"admin123@gmail.com","admin123"},{"a.gmail.com","a"}};
	}
	
	@AfterSuite
	public void tearDownDependencies() {
		driver.quit();
	}

	
	
	
	
	
	
	
	
	
}	
