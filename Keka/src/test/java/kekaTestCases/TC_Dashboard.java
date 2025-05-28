package kekaTestCases;

import org.testng.annotations.Test;
import kekaResources.KekaBase;

public class TC_Dashboard extends KekaBase {

    @Test(priority = 2)
    public void verifyDashboardButtons() throws InterruptedException {
        log.info("==== Starting Dashboard Test ====");

        log.info("Clicking dashboard buttons");
        dash.clickAllDashboardButtons();

        log.info("Printing selected date range");
        dash.printSelectedDateRange();

        log.info("==== Dashboard Test Completed ====");
    }
}
