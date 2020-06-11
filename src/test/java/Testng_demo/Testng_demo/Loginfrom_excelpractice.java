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
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Loginfrom_excelpractice {
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
	String sFile = System.getProperty("user.dir")+"/login2.xlsx";
	 return readDataFromExcelSheet(sFile);
}

public Object[][] readDataFromExcelSheet(String sFile) throws Exception {
	File f = new File(System.getProperty("user.dir")+"/login2.xlsx");
	XSSFWorkbook myExcelBook = new XSSFWorkbook(new FileInputStream(sFile));
	XSSFSheet myExcleSheet = myExcelBook.getSheet("sheet1");
	XSSFRow row1 = myExcleSheet.getRow(0);
	System.out.println(row1.getPhysicalNumberOfCells()); //To take total number of collumns
	System.out.println(myExcleSheet.getPhysicalNumberOfRows());//To take total number of Rows
	//System.out.println(row1.getLastCellNum());
	int iCountCol =row1.getLastCellNum();
	int iCountRow = myExcleSheet.getPhysicalNumberOfRows();
	Object[][] excelData= new Object[iCountRow][iCountCol]; //Creating multi dimensional array
	
	for(int countRow=0;countRow<iCountRow;countRow++) {
		for(int countCol = 0; countCol<iCountCol;countCol++) {
			XSSFRow tempRow=myExcleSheet.getRow(countRow);
			String sTemp;
			try {
			//System.out.println(tempRow.getCell(countCol).getStringCellValue());
			sTemp=tempRow.getCell(countCol).getStringCellValue();
			}catch(Exception e) {
				//System.out.println(tempRow.getCell(countCol).getNumericCellValue());
				sTemp=Double.toString(tempRow.getCell(countCol).getNumericCellValue());
			}
			excelData[countRow][countCol] = sTemp;
		}
	}	
	return excelData;















}
}
