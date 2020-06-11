package Testng_demo.Testng_demo;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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

import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Loginfrom_excelpractice2 {
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

@Test(dataProvider="logininfo")

public void invalidlogincredentials(String susername,String password) throws Exception{
	driver.findElement(By.id("email_field")).sendKeys(susername);
		
		driver.findElement(By.xpath("//input[@placeholder='Password...']")).sendKeys(password);
		driver.findElement(By.xpath("//button[contains(text(),'Login to Account')]")).click();
		WebDriverWait	 wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"))));	
//driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();	
		
		//Thread.sleep(4000);	
}



@AfterMethod
public void settingURL() {
	if(driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).isDisplayed())
	{
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		// wait = new WebDriverWait(Browser_utilities.driver, 30);
		//wait.until(ExpectedConditions.visibilityOf(Browser_utilities.driver.findElement(By.id("email_field"))));	
	}}
@AfterSuite
public void quit() {
driver.quit();	
}


@DataProvider(name="logininfo")
Object[][] trainerInfoFromExcel()throws Exception{
	String sFile = System.getProperty("user.dir")+"/login.xls";
	 return readDataFromExcelSheet_aspose(sFile);
}

private Object[][] readDataFromExcelSheet_aspose(String sFile) throws Exception {
	//Creating a file stream containing the Excel file to be opened
			FileInputStream fstream = new FileInputStream(sFile);
			
			//Instantiating a Workbook object
			Workbook workbook = new Workbook(fstream);
			
			//Accessing the first worksheet in the Excel file
			Worksheet worksheet = workbook.getWorksheets().get(0);
			
			//Exporting the contents of 7 rows and 2 columns starting from 1st cell to Array.
			Object[][] dataTable = worksheet.getCells().exportArray(0,0,3,2);
			/*for (int i = 0 ; i < dataTable.length ; i++)
			{
				System.out.println("["+ i +"]: "+ Arrays.toString(dataTable[i]));
			}*/
			//Closing the file stream to free all resources
			fstream.close();
	return dataTable;
}





}
















