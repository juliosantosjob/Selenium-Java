package tests;

import org.testng.annotations.Test;
import pages.AddProductPage;
import utils.DriverFactory;
import pages.LoginPage;

public class AddProductTest extends DriverFactory {

	@Test(priority = 5, description="Adding product to cart")
	public void AddProduct() {
		AddProductPage addProductPage = new AddProductPage(driver);
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.goToSite();
		loginPage.iFillOutMyCredentials("standard_user", "secret_sauce");
		addProductPage.selectProduct();
		addProductPage.accessMycart();
		addProductPage.seeSessionMyCart();
		addProductPage.ISeeMyProductInTheCart("Sauce Labs Bike Light");
	}
}
