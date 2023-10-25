package api.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtitilty {

	public FileInputStream fi;
	public WorkbookFactory workbook;
	public Sheet sheet;
	public Row row;
	public Cell cell;
	public XSSFWorkbook workbook1;
	String path;
	
	public XLUtitilty(String path) 
	{
		this.path = path;
	}
	public int getRowCount(String sheetname) throws IOException
	{
		   fi = new FileInputStream(path);
		   workbook1 = new XSSFWorkbook(fi);
		   sheet = workbook1.getSheet(sheetname);
		   int rowcount = sheet.getLastRowNum();
		   workbook1.close();
		   fi.close();	
		   return rowcount;
	}
	
	public int getCellCount(String sheetname,int rownum) throws IOException
	{
		   fi = new FileInputStream(path);
		   workbook1 = new XSSFWorkbook(fi);
		   sheet = workbook1.getSheet(sheetname);
		   row = sheet.getRow(rownum);
		   int cellcount = row.getLastCellNum();
		   workbook1.close();
		   fi.close();
		   return cellcount;
	}
	
	public String getCellData(String sheetname,int rownum,int colnum) throws IOException
	{
		
		   fi = new FileInputStream(path);
		   workbook1 = new XSSFWorkbook(fi);
		   sheet = workbook1.getSheet(sheetname);
		   row = sheet.getRow(rownum);
		   cell = row.getCell(colnum);
		   
		   DataFormatter formatter = new DataFormatter();
		   String data;
		   try {
			    data = formatter.formatCellValue(cell); 
		       } catch(Exception e) {
		    	   data="";
		       }
		   workbook1.close();
		   fi.close();
		   return data;
	}
	
	
	
}
