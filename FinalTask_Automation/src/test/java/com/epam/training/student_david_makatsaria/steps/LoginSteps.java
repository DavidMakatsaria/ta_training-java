package com.epam.training.student_david_makatsaria.steps;

import com.epam.training.student_david_makatsaria.pages.LoginPage;
import com.epam.training.student_david_makatsaria.util.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    private LoginPage loginPage;

    @Given("I open the login page")
    public void openLoginPage() {
        WebDriver driver = DriverFactory.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @And("I enter username {string} and password {string}")
    public void enterCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("I clear the inputs")
    public void clearInputs() {
        loginPage.clearUsernameField();
    }

    @And("I clear the password input")
    public void clearPassword() {
        loginPage.clearPasswordField();
    }

    @When("I click the login button")
    public void clickLogin() {
        loginPage.clickLogin();
    }

    @Then("I should see the error message {string}")
    public void verifyError(String expected) {
        MatcherAssert.assertThat(loginPage.getErrorMessage(), Matchers.containsString(expected));
    }

    @Then("I should land on the dashboard with title {string}")
    public void verifyTitle(String title) {
        MatcherAssert.assertThat(loginPage.getTitle(), Matchers.equalTo(title));
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
