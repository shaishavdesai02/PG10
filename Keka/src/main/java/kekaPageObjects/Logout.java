package kekaPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout 
{
	WebDriver driver;

	public Logout(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver , this);
	}
	
	//@FindBy(xpath = "//span[@class='profile-name']")
	@FindBy(xpath = "/html/body/div[2]/header/div/div/div[3]/ul/li/a/span[2]")
	WebElement profileclick;
	
	public void profileclick()
	{
		profileclick.click();
	}
	
	//*****************************************************************************************
	
	//@FindBy(xpath = "//a[@routerlink='/logout']")
	@FindBy(xpath = "/html/body/div[2]/header/div/div/div[3]/ul/li/div/div/div/a")
	WebElement logoutclick;
	
	public void logoutclick()
	{
		logoutclick.click();
	}
	

}
