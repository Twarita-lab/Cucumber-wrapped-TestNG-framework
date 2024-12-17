package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestContext;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartPage;
import pageObjects.CheckOutPage;
import pageObjects.OrderPage;
import pageObjects.OrderSuccessPage;
import pageObjects.ProductCatalogue;

public class SubmitOrderStepDefinitions extends testComponent.BaseTests {
	ITestContext context;
	public ProductCatalogue productsPage;
	public CartPage cartPage;
	public CheckOutPage checkout;
	public OrderSuccessPage orderSuccessPage;
	public OrderPage orderPage;

	@Given("I am on landing page of an ecommerce website")
	public void i_am_on_landing_page_of_an_ecommerce_website() throws IOException {
		landingPage = openUrl(context);
	}

	@Given("^I login with username (.+) and password (.+)$")
	public void i_login_with_username_test_t_mail_com_and_password_password1(String username, String password) {
		productsPage = landingPage.login(username, password);

	}

	@When("^I add product (.+) to cart$")
	public void i_add_product_zara_coat_to_cart(String productName) {
		productsPage.addProductToCart(productName);

	}

	@When("^I go to Cart Page and verify product (.+) added to cart$")
	public void i_go_to_Cart_Page(String productName) {

		cartPage = productsPage.goToCartPage();
		boolean productAddedToCart = cartPage.verifyProductAddedTocart(productName);
		Assert.assertTrue(productAddedToCart);

	}

	@When("^I click on Submit Order with country name (.+)$")
	public void i_click_on_submit_order_with_country_name_india(String countryName) {
		checkout = cartPage.checkout();
		orderSuccessPage = checkout.checkOutWithCountryName(countryName);

	}

	@Then("{string} success message displayed on order confirmation page")
	public void success_message_displayed(String orderSucessMessage) {
		boolean successMessageMatchs = orderSuccessPage.validateOrderPlaced(orderSucessMessage);
		Assert.assertTrue(successMessageMatchs);
		System.out.println(orderSuccessPage.GetOrderNumber());

	}

	@When("I go to Orders page")
	public void i_go_to_orders_page() {
		orderPage = productsPage.goToOrderPage();
	}

	@Then("^Verify (.+) displayed in orders table$")
	public void verify_zara_coat_displayed_in_orders_table(String productName) {
		boolean orderPlaced = orderPage.verifyOrderPlaced(productName);
		Assert.assertTrue(orderPlaced);

	}
	
	@Then("{string} error message displayed on login page")
	public void error_message_displayed_on_login_page(String errorMessage) {
		Assert.assertEquals(landingPage.getLoginError(), errorMessage);

	}
	
	 @Then ("^On adding (.+) product no product gets added$")
	 public void On_adding_product_no_product_gets_added(String productname) {
		 Assert.assertEquals(productsPage.getProduct(productname),null);
	 }
}