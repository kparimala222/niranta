package com.pom;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {
	
	@Test(dataProvider="getData")
	public void data(String uname, String pword){
		System.setProperty("webdriver.chrome.driver", "F:\\chrome\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://facebook.com");
		driver.findElementById("email").sendKeys(uname);
		driver.findElementByXPath(".//*[@id='pass']").sendKeys(pword);
		driver.findElementByXPath(".//*[@id='loginbutton']").click();
	}
		@DataProvider
	public Object[][] getData()
	{
	//Rows - Number of times your test has to be repeated.
	//Columns - Number of parameters in test data.
	Object[][] data = new Object[3][2];

	// 1st row
	data[0][0] ="vuday9";
	data[0][1] = "yamuna@123";

	// 2nd row
	data[1][0] ="vuday10";
	data[1][1] = "43860000";
	
	// 3rd row
	data[2][0] ="udayvang";
	data[2][1] = "priya123";

	return data;
	}

}
