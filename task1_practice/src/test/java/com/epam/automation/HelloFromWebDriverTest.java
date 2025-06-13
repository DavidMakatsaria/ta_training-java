package com.epam.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloFromWebDriverTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        HelloFromWebDriver pastebin = new HelloFromWebDriver(driver);

        try {
            pastebin.open();
            pastebin.enterCode("Hello from WebDriver");
            pastebin.setExpiration("10 Minutes");
            pastebin.enterTitle("helloweb");
            pastebin.submit();
        } finally {
            driver.quit();
        }
    }
}