package Testng_demo.Testng_demo;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Demo_dataprovider_excel2 {
	@Test(dataProvider="trainerInfo")
	public void validatingTrainerInfo(String name, String exp) {
		System.out.println(name+"\t"+exp);
}
	@DataProvider(name="trainerInfo")
	Object[][] trainerInfoFromExcel()throws Exception{
		String sFile = System.getProperty("user.dir")+"/js1.xls";
		 return readDataFromExcelSheet(sFile);
	}

	public Object[][] readDataFromExcelSheet(String sFile) throws Exception {
		File f = new File(System.getProperty("user.dir")+"/js1.xls");
		HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(sFile));
		HSSFSheet myExcleSheet = myExcelBook.getSheet("sheet1");
		HSSFRow row1 = myExcleSheet.getRow(0);
		System.out.println(row1.getPhysicalNumberOfCells()); //To take total number of collumns
		System.out.println(myExcleSheet.getPhysicalNumberOfRows());//To take total number of Rows
		//System.out.println(row1.getLastCellNum());
		int iCountCol =row1.getLastCellNum();
		int iCountRow = myExcleSheet.getPhysicalNumberOfRows();
		Object[][] excelData= new Object[iCountRow][iCountCol]; //Creating multi dimensional array
		
		for(int countRow=0;countRow<iCountRow;countRow++) {
			for(int countCol = 0; countCol<iCountCol;countCol++) {
				HSSFRow tempRow=myExcleSheet.getRow(countRow);
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