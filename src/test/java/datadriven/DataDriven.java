package datadriven;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDriven {
	static XSSFSheet sh1;
	static WebDriver driver;
	public static void main(String[] args) throws IOException {
	
		
		//specify the path of the file
		File src=new File("F:\\Selinium2018\\niranta\\ExcelData\\Datasheet.xlsx");
		//Load file
		  FileInputStream fis=new FileInputStream(src);
		   XSSFWorkbook wb=new XSSFWorkbook(fis);
		   sh1= wb.getSheetAt(0);
		   // getRow() specify which row we want to read.
		   
		   // and getCell() specify which column to read.
		   // getStringCellValue() specify that we are reading String data.
		   
		  System.out.println("rowcount is  "+sh1.getLastRowNum());
		   for(int j=0;j<=6;j++)
		   {
			   for (int i=0;i<sh1.getLastRowNum()-2;i++)
			   { 
				   System.out.print(sh1.getRow(j).getCell(i).getStringCellValue()+"  ");  
			   }
			   System.out.println("");
		   }
		   for (int row = 1; row < sh1.getLastRowNum()-2; row++) {
				String ActionKeyword =sh1.getRow(row).getCell(1).getStringCellValue();
				String LocatorType =  sh1.getRow(row).getCell(2).getStringCellValue();
				String LocatorValue = sh1.getRow(row).getCell(3).getStringCellValue();
				String testData = sh1.getRow(row).getCell(4).getStringCellValue();
				
				System.out.println(ActionKeyword+"  "+LocatorType+"  "+LocatorValue+"  "+testData);
				switch (ActionKeyword) {
				case "Open_Browser":
				{
					System.setProperty("webdriver.chrome.driver", "F:\\chrome\\chromedriver.exe");
					driver = new ChromeDriver();
					break;
				
					
				}
				case "Launch url":
				{
					driver.get("http://google.com");
				}
				
				
				
				
				}
		   }
	}

	
	
}
