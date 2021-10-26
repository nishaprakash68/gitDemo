package utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataProvider {
    File file;
    FileInputStream fis;
    XSSFWorkbook wb;
    XSSFSheet sheet;

    public DataProvider() throws IOException {
        file = new File(System.getProperty("user.dir") + "//files//TestData.xlsx");
        fis = new FileInputStream(file);
    }
  
    
    public Map<String,String> getDetails() throws IOException {
        wb=new XSSFWorkbook(fis);
        sheet=wb.getSheetAt(0);
        wb.close();
        int lastRow = sheet.getLastRowNum();
        int lastRowCell = sheet.getRow(0).getLastCellNum();
        Map<String,String> map=new HashMap<>();
        for (int i=0;i<lastRow;i++){
            for (int j = 0; j < lastRowCell; j++) {

                String test=sheet.getRow(0).getCell(j).toString() + i;
                map.put(test, sheet.getRow(i + 1).getCell(j).toString());
                System.out.println(test);
            }
        }
        return map;
    }
    
    public Map<String,String> getGmailDetails() throws IOException {
        wb=new XSSFWorkbook(fis);
        sheet=wb.getSheetAt(1);
        wb.close();
        int lastRow = sheet.getLastRowNum();
        int lastRowCell = sheet.getRow(0).getLastCellNum();
        Map<String,String> map=new HashMap<>();
        for (int i=0;i<lastRow;i++){
            for (int j = 0; j < lastRowCell; j++) {

                String test=sheet.getRow(0).getCell(j).toString() + i;
                map.put(test, sheet.getRow(i + 1).getCell(j).toString());
            }
        }
        return map;
    }
}
