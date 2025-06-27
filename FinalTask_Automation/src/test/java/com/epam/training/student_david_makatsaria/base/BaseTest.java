package com.epam.training.student_david_makatsaria.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import com.epam.training.student_david_makatsaria.pages.LoginPage;
import com.epam.training.student_david_makatsaria.util.DriverFactory;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        driver = DriverFactory.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}