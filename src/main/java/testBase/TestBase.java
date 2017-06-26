package testBase;



import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;


public class TestBase {
	static WebDriver driver;
	static WebDriverWait wait;

	public void Open_Browser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("Firefox")) {
				 System.setProperty("webdriver.gecko.driver",
						 "F:\\gecko\\geckodriver.exe");
				//driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"F:\\chrome\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver",
						"F:\\ie\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
		
	}

	public void enter_URL(String URL) {
		driver.navigate().to(URL);
	}

	public By locatorValue(String locatorTpye, String value) {
		By by;
		switch (locatorTpye) {
		case "id":
			by = By.id(value);
			break;
		case "name":
			by = By.name(value);
			break;
		case "xpath":
			by = By.xpath(value);
			break;
		case "css":
			by = By.cssSelector(value);
			break;
		case "class":
			by = By.className(value);
			break;
		case "linkText":
			by = By.linkText(value);
			break;
		case "partialLinkText":
			by = By.partialLinkText(value);
			break;
		default:
			by = null;
			break;
		}
		return by;
	}

	public void enter_Text(String locatorType, String value, String text) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			element.sendKeys(text);
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to enter text" + e);
		}
	}

	public void click_On_Link(String locatorType, String value) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			element.click();
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to enter text" + e);
		}
	}

	public void click_On_Button(String locatorType, String value) {
		try {
			By locator;
			locator = locatorValue(locatorType, value);
			WebElement element = driver.findElement(locator);
			element.click();
			
			
			
		} catch (NoSuchElementException e) {
			System.err.format("No Element Found to perform click" + e);
		}
	}
	
	public void close_Browser() {
		driver.quit();
	}

	public String getTitle() {
		String title=driver.getTitle();
		return title;
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
	
	public void tearDown() {
		if(driver!=null) {
			System.out.println("Closing browser");
			driver.quit();
		}
		}
}