package regression;

import org.testng.annotations.Test;

import testBase.TestBase;
import excelReader.ReadExcel;

public class FaceBookTest {

	TestBase k= new TestBase();
	@Test
  public void FacebookLogin() {
  	  ReadExcel excelSheet = new ReadExcel();
  	String Sheet="Sheet2";
	excelSheet.openSheet(Sheet);
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
