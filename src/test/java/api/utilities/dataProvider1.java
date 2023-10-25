package api.utilities;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;

public class dataProvider1 {
  
    @DataProvider(name = "Data")
    public String[][] getAllData() throws IOException {
        String path = "C:\\Users\\BizAct-117\\Downloads\\BookExcelsheet.xlsx (1).xlsx";
        XLUtitilty xl = null;
        
        try {
            xl = new XLUtitilty(path);
            int rownum = xl.getRowCount("Sheet1");
            int colcount = xl.getCellCount("Sheet1", 0);

            String[][] data = new String[rownum][colcount];

            for (int i = 1; i < rownum-1; i++) {
                for (int j = 0; j <=colcount-1; j++) {
                    data[i-1][j] = xl.getCellData("Sheet1", i, j);
                }
            }

            return data;
        } catch (EncryptedDocumentException | IOException | NullPointerException e) {
            // Log the exception, you can also return or handle it differently if needed.
            e.printStackTrace();
            return null;
        } 
    }
    
    @DataProvider(name = "UserNames")
    public String[] getUsernames() throws IOException {
        String path = "C:\\Users\\BizAct-117\\Downloads\\BookExcelsheet.xlsx (1).xlsx";
        XLUtitilty xl = null;
        
        try {
            xl = new XLUtitilty(path);
            int rownum = xl.getRowCount("Sheet1");
            String[] data = new String[rownum];
            
            for (int i = 1; i < rownum-1; i++) {
                data[i-1] = xl.getCellData("Sheet1", i, 0);
            }
            
            return data;
        } catch (EncryptedDocumentException | IOException | NullPointerException e) {
            // Log the exception, you can also return or handle it differently if needed.
            e.printStackTrace();
            return null;
        } 
        }
    }


