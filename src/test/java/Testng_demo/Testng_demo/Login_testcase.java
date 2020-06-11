package Testng_demo.Testng_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Login_testcase {
	@BeforeSuite
	public void dependencyTriggering() {
	Browser_utilities.launchbrowser("ch");
	}
	
	
	@BeforeMethod
	public void login() {
Browser_utilities.driver.get("https://qa-tekarch.firebaseapp.com/"); 
	}
	
	@Test
	public void checkLoginSuccessOrNot_InvalidCredentials() throws Exception{
		System.out.println("11111");
	Browser_utilities.logintobrowser("admin123@gmail.com", "admin3");
	}
	
	@Test
	public void checkLoginSuccessOrNot_ValidCredentials() throws Exception{
		System.out.println("2222");
	Browser_utilities.logintobrowser("admin123@gmail.com", "admin123");
	}
	@AfterMethod
	public void settingURL() {
		if(Browser_utilities.driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).isDisplayed())
		{
			Browser_utilities.driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
			// wait = new WebDriverWait(Browser_utilities.driver, 30);
			//wait.until(ExpectedConditions.visibilityOf(Browser_utilities.driver.findElement(By.id("email_field"))));	
		}
	
	}
	
	
	
	
	
	@AfterSuite
	public void tearDownDependencies() {
		Browser_utilities.quitbrowser();
	}
}
