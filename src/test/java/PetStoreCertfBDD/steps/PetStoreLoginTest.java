package PetStoreCertfBDD.steps;

import org.openqa.selenium.WebDriver;

import Config.WebDriverConfig;
import Helpers.PageManager;
import PageObjects.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PetStoreLoginTest {
	WebDriver driver;
	LoginPage loginPage;
	PageManager pageManager;

	@Given("I am at the Pet Store Login page using {string}")
	public void i_am_at_the_pet_store_login_page_using(String browser) {
		driver = WebDriverConfig.startBrowser(browser);
		loginPage = new LoginPage(driver);
		pageManager = new PageManager(driver);
		driver.get(
				"https://petstore.octoperf.com/actions/Account.action;jsessionid=F7FA4F107DBE97B29BCEB0F877DD17F4?signonForm=");
	}

	@When("I enter a valid username and password")
	public void i_enter_a_valid_username_and_password() {
		loginPage.insertValidLogin("EL9010Z", "passwordDeTeste123");
	}

	@And("I click on the Login")
	public void i_click_on_the_login() {
		loginPage.clickLogin();
	}

	@Then("I should be redirected to the home page")
	public void i_should_be_redirected_to_the_home_page() {
		pageManager.verifyHomepage();

	}

	@After
	public void closeBrowser() {
		WebDriverConfig.closeBrowser(driver);
	}

}
