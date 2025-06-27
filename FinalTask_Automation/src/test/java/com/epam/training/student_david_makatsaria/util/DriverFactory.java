package com.epam.training.student_david_makatsaria.util;

import org.openqa.selenium.WebDriver;
import com.epam.training.student_david_makatsaria.util.strategy.*;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = System.getProperty("browser", "edge");
            BrowserStrategy strategy = switch (browser.toLowerCase()) {
                case "firefox" -> new FirefoxStrategy();
                default -> new EdgeStrategy();
            };
            driver = strategy.createDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

