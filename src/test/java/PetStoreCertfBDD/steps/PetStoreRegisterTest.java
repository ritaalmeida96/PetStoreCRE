package PetStoreCertfBDD.steps;

import org.openqa.selenium.WebDriver;

import Config.WebDriverConfig;
import Helpers.Helper;
import Helpers.PageManager;
import PageObjects.RegisterPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PetStoreRegisterTest {
	WebDriver driver;
	RegisterPage registerPage;
	PageManager pageManager;

	@Given("I am at the Pet Store Register page using {string}")
	public void i_am_at_the_pet_store_register_page_using(String browser) {
		driver = WebDriverConfig.startBrowser(browser);
		registerPage = new RegisterPage(driver);
		pageManager = new PageManager(driver);
		driver.get("https://petstore.octoperf.com/actions/Account.action?newAccountForm=");
	}

	@When("I enter valid user and account information")
	public void i_enter_valid_user_and_account_information() {
		registerPage.insertUserInfo(Helper.generateRandomID(), "passwordDeTeste123", "passwordDeTeste123");
		registerPage.insertNames("primeiroNome", "ultimoNome");
		registerPage.insertContacts("email@emaildeteste.com", "910000000");
		registerPage.insertAddressLines("linha1", "linha2");
		registerPage.insertCityInfo("cidade", "estado", "1234", "pais");
	}

	@When("I click on Save Account")
	public void i_click_on_save_account() {
		registerPage.clickSaveAccount();
	}

	@Then("I should be redirected from Register to the home page")
	public void i_should_be_redirected_from_register_to_the_home_page() {
		pageManager.verifyHomepage();
	}

	@After
	public void closeBrowser() {
		WebDriverConfig.closeBrowser(driver);
	}

}
