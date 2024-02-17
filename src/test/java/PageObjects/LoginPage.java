package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private final WebDriver driver;
	private WebElement waitLogin;

	// --------- LOCATORS for USER LOGIN ---------
	private final By elementUsernameInput = By.xpath("//input[@name='username']");
	private final By elementPasswordInput = By.xpath("//input[@name='password']");
	private final By elementButtonLogin = By.xpath("//input[@name='signon']");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// --- Insert User Valid Information ---
	public void insertValidLogin(String username, String password) {

		// --- User ID ---
		waitLogin = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementUsernameInput));
		waitLogin.clear();
		waitLogin.sendKeys(username);

		// --- Password ---
		waitLogin = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementPasswordInput));
		waitLogin.clear();
		waitLogin.sendKeys(password);

	}

	// --- Click the Login Button ---
	public void clickLogin() {
		waitLogin = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementButtonLogin));
		waitLogin.click();
	}

}
