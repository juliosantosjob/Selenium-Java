package pages;

import elements.LoginElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends LoginElements {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void goToSite() {
		driver.findElement(By.cssSelector(ImgHomeSite));
	}

	public void iFillOutMyCredentials(String userName, String password) {
		driver.findElement(By.cssSelector(FieldUsrName)).sendKeys(userName);
		driver.findElement(By.cssSelector(FieldPassword)).sendKeys(password);
		driver.findElement(By.cssSelector(Submit)).click();
	}

	public String loggedAreaTitle() {
		return driver.findElement(By.cssSelector(loggedTitle)).getText();
	}

	public String errorReturned() {
		return driver.findElement(By.tagName(errorMessage)).getText();
	}
}