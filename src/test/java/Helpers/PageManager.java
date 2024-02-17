package Helpers;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageManager {
	private final WebDriver driver;

	public PageManager(WebDriver driver) {
		this.driver = driver;
	}

	// --- Assert if the redirected url is the same expected ---
	public void verifyHomepage() {

		try {
			new WebDriverWait(driver, Duration.ofSeconds(25))
					.until(ExpectedConditions.urlContains("/actions/Catalog.action"));
		} catch (Exception e) {
			// Take a screenshot if assertion fails
			Helper.takeScreenshot(driver, "redirect_failureLogin");
			// Re-throw the exception to fail the test
			throw e;
		}
	}
}