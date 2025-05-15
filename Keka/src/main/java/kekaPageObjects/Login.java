package kekaPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login 
{
	WebDriver driver;

	public Login(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		
		this.driver=driver;
		PageFactory.initElements(driver , this);
	}
	
	//***************************************************************************************
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/form/div[1]/input")
	WebElement username;
	
	public void username(String usrname)
	{
		username.click();		
		username.sendKeys(usrname);
	}
	
	//***************************************************************************************
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/form/div[2]/input")
	WebElement enterpass;
	
	public void enterpass(String pass)
	{
		enterpass.sendKeys(pass);
	}
	
	//****************************************************************************************
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/form/div[3]/button")
	WebElement pclickonlogin;
	
	public void pclickonlogin()
	{
		pclickonlogin.click();
	}
}
