package Testng_demo.Testng_demo;

import java.util.function.Function;
import org.jsoup.select.Evaluator.Id;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Browser_utilities {

	

public static WebDriver driver=null;
static void launchbrowser(String sbrowser) {
if(sbrowser.startsWith("ch")) {	
WebDriverManager.chromedriver().setup();
//System.setProperty("webdriver.chrome.driver", "C:\\Users\\hanuma\\Downloads\\chromedriver_win32_2020\\chromedriver.exe");
		driver = new ChromeDriver();}
else {
	System.out.println("You have not given browser type correctly");
}
driver.manage().window().maximize(); 
driver.get("https://qa-tekarch.firebaseapp.com/"); 

}
static void quitbrowser() {
driver.quit();
}
static void logintobrowser(String suserName,String spassword) throws Exception{
	driver.get("https://qa-tekarch.firebaseapp.com/"); 
	WebDriverWait wait=new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email_field"))));
	//driver.findElement(By.id("email_field")).sendKeys("admin123@gmail.com");
	driver.findElement(By.id("email_field")).sendKeys(suserName);
	//driver.findElement(By.xpath("//input[@placeholder='Password...']")).sendKeys("admin123");
	driver.findElement(By.xpath("//input[@placeholder='Password...']")).sendKeys(spassword);
	driver.findElement(By.xpath("//button[contains(text(),'Login to Account')]")).click();
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"))));
}
static void waitforpageelementtoVisible(WebElement eletowait) {
	WebDriverWait wait=new WebDriverWait(Browser_utilities.driver,30);
	wait.until(ExpectedConditions.visibilityOf(eletowait));
}
}