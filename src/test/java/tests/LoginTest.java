package tests;

import org.testng.annotations.Before;
import org.testng.annotations.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.LoginPage;
import static org.junit.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class LoginTest {
	private WebDriver driver;

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
	public void loginSuccess() {
		LoginPage loginPage = new LoginPage(driver);
		String username = "standard_user";
		String password = "secret_sauce";
		String titleAreaLoged = "PRODUCTS";

		loginPage.goToSite();
		loginPage.iFillOutMyCredentials(username, password);
		assertEquals(titleAreaLoged, loginPage.loggedAreaTitle());
	}

	@Test
	public void loginWithWrongUsername() {
		LoginPage loginPage = new LoginPage(driver);
		String username = "un_error";
		String password = "secret_sauce";
		String messageError = "Epic sadface: Username and password do not match any user in this service";

		loginPage.goToSite();
		loginPage.iFillOutMyCredentials(username, password);
		assertTrue(loginPage.errorReturned().contains(messageError));
	}

	@Test
	public void loginWithWrongPassword() {
		LoginPage loginPage = new LoginPage(driver);
		String username = "standard_user";
		String password = "un_error";
		String messageError = "Epic sadface: Username and password do not match any user in this service";

		loginPage.goToSite();
		loginPage.iFillOutMyCredentials(username, password);
		assertTrue(loginPage.errorReturned().contains(messageError));
	}

	@Test
	public void loginWithoutUsernameAndPassword() {
		LoginPage loginPage = new LoginPage(driver);
		String username = "";
		String password = "";
		String messageError = "Epic sadface: Username is required";

		loginPage.goToSite();
		loginPage.iFillOutMyCredentials(username, password);
		assertTrue(loginPage.errorReturned().contains(messageError));
	}

	@After
	public void closeDriver() {
		driver.quit();
	}
}
