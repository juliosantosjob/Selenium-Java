package tests;

import org.junit.Test;
import org.junit.After;
import pages.LoginPage;
import org.junit.Before;
import java.time.Duration;
import pages.AddProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AddProduct {
	WebDriver driver;

	@Before
	public void setDriver() {
		System.out.println("Starting Execution");
		String ProjectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",
				ProjectPath + "\\src\\test\\resources\\chromeDriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		String BaseUrl = "https://www.saucedemo.com/";

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(BaseUrl);
	}

	@Test
	public void AddProduct() {
		AddProductPage addProductPage = new AddProductPage(driver);
		LoginPage loginPage = new LoginPage(driver);

		String username = "standard_user";
		String password = "secret_sauce";

		loginPage.goToSite();
		loginPage.iFillOutMyCredentials(username, password);
		addProductPage.selectProduct();
		addProductPage.accessMycart();
		addProductPage.seeSessionMyCart();
		addProductPage.ISeeMyProductInTheCart("Sauce Labs Bike Light");
	}

	@After
	public void closeDriver() {
		driver.quit();
	}
}