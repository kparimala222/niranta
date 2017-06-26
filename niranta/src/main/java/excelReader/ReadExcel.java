package excelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ReadExcel  {


	XSSFWorkbook wb;
	XSSFSheet sheet;
	String Path="F:\\Selinium2018\\niranta\\src\\test\\resources\\testCaseSheet.xlsx";
		
		@BeforeMethod
		public void openSheet(String Sheet) {
			String S=Sheet;
			try { 
				File filePath1=new File(Path);
				
				FileInputStream fs=new FileInputStream(filePath1);
				 wb = new XSSFWorkbook(fs);
				 sheet= wb.getSheet(S);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@AfterMethod
		public void closeSheet() {
			try { 
				
				 FileOutputStream fout=new FileOutputStream(new File(Path));
				 wb.write(fout);
				 fout.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		@Test
		public String getValueFromCell(int iColNumber, int iRowNumber) {
			String value= sheet.getRow(iRowNumber).getCell(iColNumber).getStringCellValue();
			return value;
		}
		@Test
		public int getRowCount() {
			int r= sheet.getLastRowNum();
			return r;
		}
		@Test
		public int getColumnCount() {
			int c = sheet.getRow(0).getLastCellNum();
			return c;
		}
	}