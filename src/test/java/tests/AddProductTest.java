package tests;

import org.testng.annotations.Before;
import org.testng.annotations.After;
import org.testng.annotations.Test;
import pages.LoginPage;
import org.junit.Before;
import java.time.Duration;
import pages.AddProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddProductTest {
	WebDriver driver;

	@Before
	public void setDriver() {
		System.out.println("Start");
		ChromeOptions options = new ChromeOptions();
		String BaseUrl = "https://www.saucedemo.com/";
                WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
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
