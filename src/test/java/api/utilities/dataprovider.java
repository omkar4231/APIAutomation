package api.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class dataprovider 
{

	@DataProvider (name = "Data")
	public String[][] getAllData() throws IOException 
	          {
		       
		        String path = "C:\\Users\\BizAct-117\\Downloads\\BookExcelsheet.xlsx (1).xlsx";
//		        FileInputStream fis = new FileInputStream(excelFilePath);
//		        Sheet sheet = WorkbookFactory.create(fis).getSheet("Sheet1");

		        XLUtitilty xl = new XLUtitilty(path);
		        int rownum = xl.getRowCount("Sheet1");
		        int colcount = xl.getCellCount("Sheet1",0);
//		        int rowCount = sheet.getPhysicalNumberOfRows();
//		        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//
		        String [][] data = new String[rownum][colcount];
//
//		        for (int i = 1; i < rowCount; i++) 
//		        {
//		            Row row = sheet.getRow(i);
//		            for (int j = 0; j < colCount; j++) 
//		            {
//		                Cell cell = row.getCell(j);
//		                data[i - 1][j] = cell.toString();
//		            }
//		        }
		        for (int i =1;i<=rownum-1;i++) 
		        {
		        	for(int j =0;j<colcount;j++) 
		        	{
		        		data[i-1][j]=xl.getCellData("Sheet1",i, j);
		        	}
		        }
		        return data; 
		    } 
	         
	        @DataProvider(name ="UserNames")
	        public String[] getusername() throws IOException 
	        {
		    String path = "C:\\Users\\BizAct-117\\Downloads\\BookExcelsheet.xlsx (1).xlsx";
//	        FileInputStream fis = new FileInputStream(excelFilePath);
//	        Sheet sheet = WorkbookFactory.create(fis).getSheet("Sheet1");
             
		    XLUtitilty xl = new XLUtitilty(path);
	        int rownum =  xl.getRowCount("Sheet1");
	        String data[]= new String[rownum];
	        
	        for(int i=0;i<=rownum-1;i++) 
	        {
	        	data[i]=xl.getCellData("Sheet1",i, 0);
	        }
	        return data;
	        }
   }
	    
       
