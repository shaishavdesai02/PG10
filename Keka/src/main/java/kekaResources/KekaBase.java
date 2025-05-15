package kekaResources;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

import kekaPageObjects.Login;
import kekaPageObjects.Logout;

public class KekaBase 
{
	public static Logger log = Logger.getLogger(KekaBase.class.getName());
	public static WebDriver driver;
	public Login lgn;
	public Logout lgo;
	
	@BeforeTest
	public WebDriver initalizeDriver()
	{
		DOMConfigurator.configure("log4j.xml"); 
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\india\\OneDrive\\Desktop\\Softwares\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		//WebDriver driver = new ChromeDriver(options);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();		
		log.info(" Open chrome and window will maimize");
		driver.get("https://test.paygate10.com/Login");
		log.info("Open Project (PG10) URL");
		return driver;
	}
	
	@BeforeClass
	public void objectCreate()
	{
		lgn = new Login(driver);
		lgo = new Logout(driver);
	}
	
	@AfterTest
	public void terminateDriver()
	{
		driver.quit();
	}
}
