package com.epam.automation;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class HelloFromWebDriver {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Constructor
    public HelloFromWebDriver(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Page interactions
    public void open() {
        driver.get("https://pastebin.com/");
    }

    public void enterCode(String code) {
        WebElement codeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("postform-text")));
        codeInput.sendKeys(code);
    }

    public void setExpiration(String optionText) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-postform-expiration-container")));
        dropdown.click();

        List<WebElement> options = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("select2-results__option")));
        for (WebElement option : options) {
            if (option.getText().equals(optionText)) {
                option.click();
                break;
            }
        }
    }

    public void enterTitle(String title) {
        WebElement titleInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("postform-name")));
        titleInput.sendKeys(title);
    }

    public void submit() {
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(text(), 'Create New Paste')]")));
        submitBtn.click();
    }
}