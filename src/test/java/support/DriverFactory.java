package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;

public class DriverFactory {
    protected static WebDriver driver;

    @BeforeMethod
    public void setDriver() {
        System.out.println("Start");
        String BaseUrl = "https://www.saucedemo.com/";
        ChromeOptions options = new ChromeOptions();
	options.addArguments("--headless");
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(BaseUrl);
    }

    @AfterMethod
    public void closeDriver() {
        System.out.println("Finish");
        driver.quit();
    }
}
