package com.epam.training.student_david_makatsaria.tests;

import com.epam.training.student_david_makatsaria.base.BaseTest;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.hamcrest.Matchers.containsString;

public class LoginTests extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(LoginTests.class);

    @Test
    public void testEmptyCredentials() {
        logger.info("Running UC-1: Empty Credentials Test");
        loginPage.enterUsername("anyuser");
        loginPage.enterPassword("anypass");
        loginPage.clearUsernameField();
        loginPage.clearPasswordField();
        loginPage.clickLogin();
        MatcherAssert.assertThat(loginPage.getErrorMessage(), containsString("Username is required"));
    }

    @Test
    public void testMissingPassword() {
        logger.info("Running UC-2: Missing Password Test");
        loginPage.enterUsername("anyuser");
        loginPage.enterPassword("somepass");
        loginPage.clearUsernameField();
        loginPage.clearPasswordField();
        loginPage.enterUsername("anyuser");
        loginPage.clickLogin();
        MatcherAssert.assertThat(loginPage.getErrorMessage(), containsString("Password is required"));
    }

    @ParameterizedTest
    @MethodSource("com.epam.training.student_david_makatsaria.data.CredentialsProvider#acceptedCredentials")
    public void testValidCredentials(String username, String password) {
        logger.info("Running UC-3: Valid Credentials Test with username: {}", username);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        MatcherAssert.assertThat(loginPage.getTitle(), containsString("Swag Labs"));
    }
}