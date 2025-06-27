package com.epam.training.student_david_makatsaria.util.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxStrategy implements BrowserStrategy {
    public WebDriver createDriver() {
        return new FirefoxDriver();
    }
}
