package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import java.time.Duration;
import pages.AddProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddProductTest {
	WebDriver driver;

	@BeforeClass
	public void setDriver() {
		System.out.println("Start");
		String BaseUrl = "https://www.saucedemo.com/";
                ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");
		WebDriverManager.chromedriver().setup();

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

	@AfterClass
	public void closeDriver() {
		driver.quit();
	}
}
