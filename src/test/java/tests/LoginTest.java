package tests;

import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DriverFactory;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends DriverFactory {

    @Test(priority = 1, description = "Login with wrong username")
    public void loginSuccess() {
        LoginPage loginPage = new LoginPage(driver);
        String username = "standard_user";
        String password = "secret_sauce";

        loginPage.goToSite();
        loginPage.iFillOutMyCredentials(username, password);
        assertEquals("PRODUCTS", loginPage.loggedAreaTitle());
    }

    @Test(priority = 3, description = "Login with wrong username")
    public void WrongUsername() {
        LoginPage loginPage = new LoginPage(driver);
        String username = "un_error";
        String password = "secret_sauce";

        loginPage.goToSite();
        loginPage.iFillOutMyCredentials(username, password);
        assertTrue(loginPage.errorReturned()
                .contains("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test(priority = 2, description = "Login with wrong password")
    public void WrongPassword() {
        LoginPage loginPage = new LoginPage(driver);
        String username = "standard_user";
        String password = "un_error";

        loginPage.goToSite();
        loginPage.iFillOutMyCredentials(username, password);
        assertTrue(loginPage.errorReturned()
                .contains("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test(priority = 4, description = "Login with wrong password end username")
    public void WithoutUsernameAndPassword() {
        LoginPage loginPage = new LoginPage(driver);
        String username = "";
        String password = "";

        loginPage.goToSite();
        loginPage.iFillOutMyCredentials(username, password);
        assertTrue(loginPage.errorReturned()
                .contains("Epic sadface: Username is required"));
    }
}
