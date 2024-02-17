package PageObjects;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	private final WebDriver driver;
	private WebElement waitCart;

	// --------- LOCATORS for ADD TO CART ---------
	private final By elementAddToCart = By.cssSelector("tbody tr:nth-child(2) td:nth-child(5) a:nth-child(1)");
	private final By elementCartTitle = By.xpath("//h2[normalize-space()='Shopping Cart']");

	public CartPage(WebDriver driver) {
		this.driver = driver;
	}

	public void pressAddToCart() {
		waitCart = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementAddToCart));
		waitCart.click();

	}

	public void verifyCartTitle() {
		waitCart = new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(elementCartTitle));

		String cartText = waitCart.getText();
		Assert.assertTrue(cartText.contains("Shopping Cart"));
		System.out.println("O titulo da página é: " + cartText);
	}

}
