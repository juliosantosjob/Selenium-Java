package pages;

import org.testing.Assert;

import org.openqa.selenium.By;
import elements.AddProductElements;
import org.openqa.selenium.WebDriver;

public class AddProductPage extends AddProductElements {
	WebDriver driver;

	public AddProductPage(WebDriver driver) {
		this.driver = driver;
	}

	public void selectProduct() {
		driver.findElement(By.xpath(btnAddToCard)).click();
	}

	public void accessMycart() {
		driver.findElement(By.cssSelector(btnCart)).click();
	}

	public void seeSessionMyCart() {
		String titleYC = driver.findElement(By.cssSelector(titleYourCart)).getText();
		String titleYourCart = titleYC.toLowerCase();

		assertEquals("your cart", titleYourCart);
	}

	public void ISeeMyProductInTheCart(String product) {
		String myProduct = driver.findElement(By.xpath(fieldProduct)).getText();
		assertEquals(product, myProduct);
	}
}
