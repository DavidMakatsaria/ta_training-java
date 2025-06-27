package com.epam.training.student_david_makatsaria.util.strategy;

import org.openqa.selenium.WebDriver;

public interface BrowserStrategy {
    WebDriver createDriver();
}