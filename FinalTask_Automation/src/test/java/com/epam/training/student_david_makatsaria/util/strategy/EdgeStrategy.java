package com.epam.training.student_david_makatsaria.util.strategy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeStrategy implements BrowserStrategy {
    public WebDriver createDriver() {
        return new EdgeDriver();
    }
}