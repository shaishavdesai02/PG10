package kekaTestCases;

import org.testng.annotations.Test;

import kekaResources.KekaBase;

public class TC_LoginPage extends KekaBase {

	@Test(priority = 1)

	public void login() throws InterruptedException {
		
		lgn.username("ShaishavQA");
		log.info("Enter username in username field");
		
		lgn.enterpass("Payfuture@123456789");
		log.info("Enter password in password field");
	
		lgn.pclickonlogin();
		log.info("Click on the Login Button after enter password");
		Thread.sleep(3000);	
	}
	
	
}
