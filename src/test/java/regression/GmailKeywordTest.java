package regression;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import testBase.TestBase;
import excelReader.ReadExcel;

public class GmailKeywordTest {

	TestBase k= new TestBase();
  @Test
  public void google() {
  	  ReadExcel excelSheet = new ReadExcel();
  	Logger logger = Logger.getLogger(GmailKeywordTest.class);
  	
  	logger.info("This is my first log4j's statement");
  	String Sheet="Sheet1";
	excelSheet.openSheet(Sheet);
	logger.info("excel sheet opened");
  	  System.out.println("Row size = " +excelSheet.getRowCount());
		for (int row = 1; row < excelSheet.getRowCount()-1; row++) {
			String ActionKeyword = excelSheet.getValueFromCell(1, row);
			String LocatorType =  excelSheet.getValueFromCell(2, row);
			String LocatorValue =  excelSheet.getValueFromCell(3, row);
			String testData =  excelSheet.getValueFromCell(4, row);
									
			switch (ActionKeyword) {
			case "Open_Browser":
			{
				System.setProperty("webdriver.chrome.driver", "F:\\chrome\\chromedriver.exe");
				k.Open_Browser(testData);
				break;
			}
			case "enter_URL": 
				k.enter_URL(testData);
				break;
			case "click_On_Link":
				k.click_On_Link(LocatorType, LocatorValue);
				break;
			case "enter_Text":
				k.enter_Text(LocatorType, LocatorValue, testData);
				break;
			case "click_On_Button":
				k.click_On_Link(LocatorType, LocatorValue);
				break;
			case "close_Browser":
				k.close_Browser();
				break;
			}
			System.out.println("Congratulation TestStep " + row + " Passed successfully");
			
			
		}
		
}
}
