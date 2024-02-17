package PetStoreCertfBDD.steps;

import org.openqa.selenium.WebDriver;

import Config.WebDriverConfig;
import Helpers.ProductManager;
import PageObjects.LoginPage;
import PageObjects.ProductPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PetStoreProductTest {
	WebDriver driver;
	LoginPage loginPage;
	ProductPage productPage;
	ProductManager productManager;

	@Given("I am Logged into Pet Store using {string}")
	public void i_am_logged_into_pet_store_using(String browser) {

		// --- Page SetUp ---
		driver = WebDriverConfig.startBrowser(browser);
		loginPage = new LoginPage(driver);
		productPage = new ProductPage(driver);
		productManager = new ProductManager(driver);
		driver.get(
				"https://petstore.octoperf.com/actions/Account.action;jsessionid=F7FA4F107DBE97B29BCEB0F877DD17F4?signonForm=");

		// --- Login to Pet Store---
		loginPage.insertValidLogin("EL9010Z", "passwordDeTeste123");
		loginPage.clickLogin();
	}

	@When("I search for a product and press ENTER")
	public void i_search_for_a_product_and_press_enter() {
		productPage.searchProduct("fish");
	}

	@When("I open a product from the search result")
	public void i_open_a_product_from_the_search_result() {
		productPage.clickSearchResult();

	}

	@Then("I have the product detail information")
	public void i_have_the_product_detail_information() {
		productManager.verifySearchResult();
	}

	@After
	public void closeBrowser() {
		WebDriverConfig.closeBrowser(driver);
	}

}
