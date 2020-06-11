package Testng_demo.Testng_demo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Extentreport_salesforce {
	public WebDriver driver;
	 public ExtentHtmlReporter htmlReporter;
	 public ExtentReports extent;
	 public ExtentTest test;
	 
	 @BeforeTest
	 public void setExtent() {
	  // specify location of the report
	  htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/myReport2.html");
	  htmlReporter.config().setDocumentTitle("Automation Report"); // Tile of report
	  htmlReporter.config().setReportName("Functional Testing1"); // Name of the report
	  htmlReporter.config().setTheme(Theme.DARK);
	  
	  extent = new ExtentReports();
	  extent.attachReporter(htmlReporter);
	  
	  // Passing General information
	  extent.setSystemInfo("Host name", "localhost");
	  extent.setSystemInfo("Environemnt", "QA");
	  extent.setSystemInfo("user", "sharmi");
	 }

@AfterTest
public void endReport() {
 extent.flush();
} 

@BeforeMethod
public void setup() {
 WebDriverManager.chromedriver().setup();
 driver = new ChromeDriver();
 
 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
 driver.manage().window().maximize();
 driver.get("https://www.salesforce.com/");
}
@Test(priority=1)
public void login() {
	test = extent.createTest("logintestcase");
	
WebElement login=driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
login.click();
driver.findElement(By.id("username")).sendKeys("sweety.1428@gmail.com");
driver.findElement(By.id("password")).sendKeys("test@123");
driver.findElement(By.id("Login")).click();
String title = driver.getTitle();
System.out.println(title);

Assert.assertEquals(title, "Salesforce - Developer Edition");

}







@Test(priority=2)
public void Logininvalid1() throws InterruptedException {
 test = extent.createTest("login invalid1 ");
 
 //test.createNode("Login with Valid input");
 WebElement login=driver.findElement(By.xpath("//a[contains(text(),'Login')]"));
 login.click();
 driver.findElement(By.id("username")).sendKeys("sharmila A");
 driver.findElement(By.id("password")).sendKeys("test@12");
 driver.findElement(By.id("Login")).click();
//Thread.sleep(3000);
 String title = driver.getTitle();
 System.out.println(title);

 Assert.assertEquals(title, "Salesforce - Developer Edition");

 
 
}
 @Test(priority=3)
 public void logininvalid2() {
 //test.createNode("Login with In-valid input");
	 test=extent.createTest("login invalid2");
 driver.findElement(By.id("username")).sendKeys("sharmila A");
 driver.findElement(By.id("password")).sendKeys("test@1");
 driver.findElement(By.id("Login")).click();
 String title = driver.getTitle();
 System.out.println(title);

 Assert.assertEquals(title, "Salesforce - Developer Edition");

// Assert.assertTrue(true);
}


@AfterMethod
public void tearDown(ITestResult result) throws IOException {
 if (result.getStatus() == ITestResult.FAILURE) {
  test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
  test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
  String screenshotPath = Extentreport_salesforce.getScreenshot(driver, result.getName());
  test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
 } else if (result.getStatus() == ITestResult.SKIP) {
  test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
 }	 
 else if (result.getStatus() == ITestResult.SUCCESS) {
	   test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
	  }
	  driver.quit();
	 }
	 
	 public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
	  String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	  TakesScreenshot ts = (TakesScreenshot) driver;
	  File source = ts.getScreenshotAs(OutputType.FILE);
	  
	  // after execution, you could see a folder "FailedTestsScreenshots" under src folder
	  String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateName + "ts1.png";
	  File finalDestination = new File(destination);
	  FileUtils.copyFile(source, finalDestination);
	  return destination;
	 } 









}

