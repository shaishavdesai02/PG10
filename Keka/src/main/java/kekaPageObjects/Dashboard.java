package kekaPageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard {

	WebDriver driver;
	WebDriverWait wait;

	public Dashboard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	    
	// Date range input box
	@FindBy(xpath = "/html/body/div[2]/div/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/div[1]/input")
	WebElement dateRangeField;

	// "Last 30 Days" option in the date picker dropdown
	@FindBy(xpath = "/html/body/div[3]/div[1]/ul/li[4]")
	WebElement last30DaysOption;
	
    public void printSelectedDateRange() {
        String selectedDateRange = dateRangeField.getDomProperty("value");
        System.out.println("Selected Date Range: " + selectedDateRange);
    }
		
	@FindBy(xpath = "/html/body/div[2]/div/div[1]/div[1]/div/div/div[2]/div[1]/div[3]/div/button[1]")
	WebElement filterButton;

	@FindBy(xpath = "/html/body/div[2]/div/div[1]/div[1]/div/div/div[2]/div[1]/div[3]/div/button[2]")
	WebElement viewTxsButton;

	@FindBy(xpath = "/html/body/div[2]/div/div[1]/div[1]/div/div/div[2]/div[1]/div[3]/div/a[1]")
	WebElement velocityButton;

	@FindBy(xpath = "/html/body/div[2]/div/div[1]/div[1]/div/div/div[2]/div[1]/div[3]/div/a[2]")
	WebElement velocityWithPendingButton;

	@FindBy(xpath = "/html/body/div[2]/div/div[1]/div[1]/div/div/div[2]/div[1]/div[3]/div/button[3]")
	WebElement resetButton;
	
	public void clickAllDashboardButtons() throws InterruptedException {
		
		 wait.until(ExpectedConditions.elementToBeClickable(dateRangeField)).click();
		 Thread.sleep(500); // optional wait for dropdown to appear
		 wait.until(ExpectedConditions.elementToBeClickable(last30DaysOption)).click();
		 Thread.sleep(500); // optional wait to allow update

		 // Now print the selected date range
		 printSelectedDateRange();

		 wait.until(ExpectedConditions.elementToBeClickable(filterButton)).click();
		 Thread.sleep(500);

		 handleNewTabClick(viewTxsButton, "View Txs");
		 Thread.sleep(500);

		 handleNewTabClick(velocityButton, "Velocity");
		 Thread.sleep(500);

		 handleNewTabClick(velocityWithPendingButton, "Velocity With Pending");
		 Thread.sleep(500);
    }

    private void handleNewTabClick(WebElement button, String label) throws InterruptedException {
        String originalTab = driver.getWindowHandle();

        button.click();
        Thread.sleep(1000);

        // Switch to new tab
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        for (String tab : tabs) {
            if (!tab.equals(originalTab)) {
                driver.switchTo().window(tab);
                break;
            }
        }

        Thread.sleep(1000);

        // Check if "No Records Found" is present
        if (driver.getPageSource().contains("No data available in table")) {
            System.out.println(label + " → No Records Found");
        } else {
            System.out.println(label + " → Data Found");
        }

        // Close new tab and switch back
        driver.close();
        driver.switchTo().window(originalTab);
		
		wait.until(ExpectedConditions.elementToBeClickable(resetButton)).click();
		Thread.sleep(1000);
    }

}
