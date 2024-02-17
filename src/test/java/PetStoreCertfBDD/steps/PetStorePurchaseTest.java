package PetStoreCertfBDD.steps;

import org.openqa.selenium.WebDriver;

import Config.WebDriverConfig;
import Helpers.Helper;
import Helpers.ProductManager;
import PageObjects.CartPage;
import PageObjects.LoginPage;
import PageObjects.ProductPage;
import PageObjects.PurchasePage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PetStorePurchaseTest {
	WebDriver driver;
	LoginPage loginPage;
	ProductPage productPage;
	ProductManager productManager;
	CartPage cartPage;
	PurchasePage purchasePage;

	@Given("I am able to login using {string}")
	public void i_am_able_to_login_usin(String browser) {

		// --- Page SetUp ---
		driver = WebDriverConfig.startBrowser(browser);
		loginPage = new LoginPage(driver);
		productPage = new ProductPage(driver);
		productManager = new ProductManager(driver);
		cartPage = new CartPage(driver);
		purchasePage = new PurchasePage(driver);
		driver.get(
				"https://petstore.octoperf.com/actions/Account.action;jsessionid=F7FA4F107DBE97B29BCEB0F877DD17F4?signonForm=");

		// --- Login to Pet Store---
		loginPage.insertValidLogin("EL9010Z", "passwordDeTeste123");
		loginPage.clickLogin();

	}
	
	@And("I can add a product to my Cart")
	public void i_can_add_a_product_to_my_cart() {
		
		// --- Search Product ---
		productPage.searchProduct("fish");
		productPage.clickSearchResult();
		
		// --- Verify Search Result ---
		productManager.verifySearchResult();
		
		// --- Search Product ---
		cartPage.pressAddToCart();
		
		// --- Verify Item on the Shopping cart matches the search ---
		productManager.verifyCartItem();
		cartPage.verifyCartTitle();
	}
	
	@When("I click on Proceed to checkout")
	public void i_click_on_proceed_to_checkout() {
		purchasePage.pressCheckout();

	}
	
	@And("fill and confirm all the required information")
	public void fill_and_confirm_all_the_required_information() {
		
		// --- Random Information inserted by a Helper Code ---
		purchasePage.insertCardInfo(Helper.generateRandomVisaNumber(), Helper.generateRandomExpiryDate());
		purchasePage.pressContinueOrder();
		
		// --- verify that I went to the order confirmation page ---
		purchasePage.verifyOrderUrl();
		
		// --- Confirm order Details ---
		purchasePage.pressConfirmOrder();
	}
	
	@Then("I see an order confirmation")
	public void i_see_an_order_confirmation() {
		// --- Verify that I have a title confirming the order submission ---
		purchasePage.verifyConfirmationTitle();
		
		// --- Verify that the item on ORDER CONFIRMATION matches the previous ---
		productManager.verifyOrderedItem();
	}
	
	@After
	public void closeBrowser() {
		WebDriverConfig.closeBrowser(driver);
	}

}
