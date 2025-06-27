package com.epam.training.student_david_makatsaria.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.epam.training.student_david_makatsaria.steps"},
    plugin = {"pretty"},
    monochrome = true
)
public class CucumberTest {}