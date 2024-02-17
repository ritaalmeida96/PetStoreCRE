package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
	private final WebDriver driver;
	private WebElement waitRegister;

	// --------- LOCATORS for USER INFO ---------
	private final By elementUserIDInput = By.xpath("//input[@name='username']");
	private final By elementNewPassInput = By.xpath("//input[@name='password']");
	private final By elementRepeatPassInput = By.xpath("//input[@name='repeatedPassword']");

	// --------- LOCATORS for ACCOUNT INFO ---------
	private final By elementFirstNameInput = By.xpath("//input[@name='account.firstName']");
	private final By elementLastNameInput = By.xpath("//input[@name='account.lastName']");
	private final By elementEmailInput = By.xpath("//input[@name='account.email']");
	private final By elementPhoneInput = By.xpath("//input[@name='account.phone']");
	private final By elementAddress1Input = By.xpath("//input[@name='account.address1']");
	private final By elementAddress2Input = By.xpath("//input[@name='account.address2']");
	private final By elementCityInput = By.xpath("//input[@name='account.city']");
	private final By elementStateInput = By.xpath("//input[@name='account.state']");
	private final By elementZipInput = By.xpath("//input[@name='account.zip']");
	private final By elementCountryInput = By.xpath("//input[@name='account.country']");

	// --------- LOCATORS for REGISTER BUTTON ---------
	private final By elementButtonSaveAccount = By.xpath("//input[@name='newAccount']");

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	// --- Insert Register Information ---
	public void insertUserInfo(String username, String password, String repeatPassword) {

		// --- User ID ---
		waitRegister = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementUserIDInput));
		waitRegister.clear();
		waitRegister.sendKeys(username);

		// --- Password ---
		waitRegister = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementNewPassInput));
		waitRegister.clear();
		waitRegister.sendKeys(password);

		waitRegister = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementRepeatPassInput));
		waitRegister.clear();
		waitRegister.sendKeys(repeatPassword);
	}

	// --- Insert Names ---
	public void insertNames(String firstName, String lastName) {

		// --- First Name ---
		waitRegister = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementFirstNameInput));
		waitRegister.clear();
		waitRegister.sendKeys(firstName);

		// --- Last Name ---
		waitRegister = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementLastNameInput));
		waitRegister.clear();
		waitRegister.sendKeys(lastName);
	}

	// --- Insert contacts ---
	public void insertContacts(String email, String phone) {

		// --- Email ---
		waitRegister = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementEmailInput));
		waitRegister.clear();
		waitRegister.sendKeys(email);

		// --- Phone ---
		waitRegister = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementPhoneInput));
		waitRegister.clear();
		waitRegister.sendKeys(phone);
	}

	// --- Insert address lines 1 and 2 ---
	public void insertAddressLines(String address1, String address2) {

		// --- Address 1 ---
		waitRegister = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementAddress1Input));
		waitRegister.clear();
		waitRegister.sendKeys(address1);

		// --- Address 2 ---
		waitRegister = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementAddress2Input));
		waitRegister.clear();
		waitRegister.sendKeys(address2);
	}

	public void insertCityInfo(String city, String state, String Zip, String Country) {

		// --- City ---
		waitRegister = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementCityInput));
		waitRegister.clear();
		waitRegister.sendKeys("Cidade");

		// --- State ---
		waitRegister = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementStateInput));
		waitRegister.clear();
		waitRegister.sendKeys("Estado");

		// --- Zip ---
		waitRegister = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementZipInput));
		waitRegister.clear();
		waitRegister.sendKeys("012345");

		// --- Country ---
		waitRegister = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementCountryInput));
		waitRegister.clear();
		waitRegister.sendKeys("Portugal");
	}

	public void clickSaveAccount() {
		waitRegister = new WebDriverWait(driver, Duration.ofSeconds(25))
				.until(ExpectedConditions.elementToBeClickable(elementButtonSaveAccount));
		waitRegister.click();
	}

}
