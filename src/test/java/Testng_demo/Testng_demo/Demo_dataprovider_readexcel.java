package Testng_demo.Testng_demo;

import java.io.FileInputStream;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;

public class Demo_dataprovider_readexcel {
	
	
	@DataProvider(name="asposetrainerInfo")
	Object[][] trainerInfoFromExcel_aspose()throws Exception{
		String sFile = System.getProperty("user.dir")+"/login.xls";
		 
		//String spath="C:\\Users\\sweet\\eclipse-workspace\\Testng_demo\\js1.xls";
		return readDataFromExcelSheet_aspose(sFile);
	}
	//open source free tools can be used anywhere. 
	private Object[][] readDataFromExcelSheet_aspose(String sFile) throws Exception {
		//Creating a file stream containing the Excel file to be opened
				FileInputStream fstream = new FileInputStream(sFile);
				
				//Instantiating a Workbook object
				Workbook workbook = new Workbook(fstream);
				
				//Accessing the first worksheet in the Excel file
				Worksheet worksheet = workbook.getWorksheets().get(0);
				
				//Exporting the contents of 7 rows and 2 columns starting from 1st cell to Array.
				Object[][] dataTable = worksheet.getCells().exportArray(0,0,4,2);
				/*for (int i = 0 ; i < dataTable.length ; i++)
				{
					System.out.println("["+ i +"]: "+ Arrays.toString(dataTable[i]));
				}*/
				//Closing the file stream to free all resources
				fstream.close();
		return dataTable;
	}
	
}
