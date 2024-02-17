package PetStoreCertfBDD.steps;

import org.openqa.selenium.WebDriver;

import Config.WebDriverConfig;
import Helpers.ProductManager;
import PageObjects.CartPage;
import PageObjects.LoginPage;
import PageObjects.ProductPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PetStoreCartTest {
	WebDriver driver;
	LoginPage loginPage;
	ProductPage productPage;
	ProductManager productManager;
	CartPage cartPage;

	@Given("I am logged and able to search a product using {string}")
	public void i_am_logged_and_able_to_search_a_product_using(String browser) {
		
		// --- Page SetUp ---
		driver = WebDriverConfig.startBrowser(browser);
		loginPage = new LoginPage(driver);
		productPage = new ProductPage(driver);
		productManager = new ProductManager(driver);
		cartPage = new CartPage(driver);
		driver.get(
				"https://petstore.octoperf.com/actions/Account.action;jsessionid=F7FA4F107DBE97B29BCEB0F877DD17F4?signonForm=");

		// --- Login to Pet Store---
		loginPage.insertValidLogin("EL9010Z", "passwordDeTeste123");
		loginPage.clickLogin();

		// --- Product Search---
		productPage.searchProduct("fish");
		productPage.clickSearchResult();
		productManager.verifySearchResult();
	}
	
	@When("I click on the Add to Cart")
	public void i_click_on_the_add_to_cart() {
		cartPage.pressAddToCart();
	}
	
	@Then("The item added is shown at shopping cart")
	public void the_item_added_is_shown_at_shopping_cart() {
		// --- Verify Item on the Shopping cart matches the search ---
		productManager.verifyCartItem();
		cartPage.verifyCartTitle();
	}

	@After
	public void closeBrowser() {
		WebDriverConfig.closeBrowser(driver);
	}

}
