package PageObjects;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Helpers.Helper;

public class PurchasePage {
	private final WebDriver driver;
	private WebElement waitPurchase;

	// --------- LOCATORS for CHECKOUT PROCESS ---------
	private final By elementButtonCheckout = By
			.cssSelector("body > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > a:nth-child(3)");
	private final By elementCardNumber = By.xpath("//input[@name='order.creditCard']");
	private final By elementExpiryDate = By.xpath("//input[@name='order.expiryDate']");
	private final By elementContinueOrder = By.xpath("//input[@name='newOrder']");
	private final By elementConfirmOrder = By.xpath("//a[normalize-space()='Confirm']");
	
	// --------- LOCATORS for ORDER CONFIRMATION ---------
	private final By elementOrderTitle = By.xpath("//li[normalize-space()='Thank you, your order has been submitted.']");

	public PurchasePage(WebDriver driver) {
		this.driver = driver;
	}

	public void pressCheckout() {
		waitPurchase = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementButtonCheckout));
		waitPurchase.click();
	}

	public void insertCardInfo(String cardNum, String expiryDate) {
		// --- Card Number ---
		waitPurchase = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementCardNumber));
		waitPurchase.clear();
		waitPurchase.sendKeys(cardNum);

		// --- Expiry Date ---
		waitPurchase = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementExpiryDate));
		waitPurchase.clear();
		waitPurchase.sendKeys(expiryDate);
	}

	public void pressContinueOrder() {
		waitPurchase = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementContinueOrder));
		waitPurchase.click();
	}

	public void verifyOrderUrl() {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(25))
					.until(ExpectedConditions.urlContains("/actions/Order.action"));
		} catch (Exception e) {
			// Take a screenshot if assertion fails
			Helper.takeScreenshot(driver, "redirect_failureOrder");
			// Re-throw the exception to fail the test
			throw e;
		}
	}
	
	public void pressConfirmOrder() {
		waitPurchase = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementConfirmOrder));
		waitPurchase.click();		
	}
	
	public void verifyConfirmationTitle() {
		waitPurchase = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementOrderTitle));
	
		String actualTitle = waitPurchase.getText();
		Assert.assertEquals("Thank you, your order has been submitted.", actualTitle);
		System.out.println("O titulo da págine é" + actualTitle);
	}
	
}
