package kekaTestCases;

import org.testng.annotations.Test;

import kekaResources.KekaBase;

public class TC_Logout extends KekaBase {
		
	@Test(priority = 2)
	public void logout() throws InterruptedException
	{
		
		lgo.profileclick();
		log.info("Open user profile ");
		Thread.sleep(500);
		lgo.logoutclick();
		log.info("Click on logout");
		Thread.sleep(1000);
	}


}
