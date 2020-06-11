package Testng_demo.Testng_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Demo_dataprovider {
	@BeforeSuite
	public void dependencyTriggering() {
	Browser_utilities.launchbrowser("ch");
	}
	
	
	@AfterMethod
	public void settingURL() {	
		if(Browser_utilities.driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).isDisplayed())
		{
			Browser_utilities.driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
			WebDriverWait wait = new WebDriverWait(Browser_utilities.driver, 30);
			wait.until(ExpectedConditions.visibilityOf(Browser_utilities.driver.findElement(By.id("email_field"))));	
		}
	
	}
	//100 sets of datas then its a problem -DataProvider
	
	@Test(dataProvider="Data_UsernameAndPassword")
	public void checkLoginSuccessOrNot(String username, String Password) throws Exception{
		System.out.println(username+"\t"+Password);
	Browser_utilities.logintobrowser(username, Password);
	}

	@AfterSuite
	public void tearDownDependencies() {
		Browser_utilities.quitbrowser();
	}
	@DataProvider(name="Data_UsernameAndPassword")
	public Object[][] usernamePassword_dp(){
		return new Object[][] {{"admin123@gmail.com","admin123"},{"admin@admin.com","admin"},{"a.gmail.com","a"}};
	}
	
	/*@Test(dataProvider="trainerInfo")
	public void validatingTrainerInfo(String name, String exp, String email) {
		System.out.println(name+"\t"+exp+"\t"+email);
	}*/
}
