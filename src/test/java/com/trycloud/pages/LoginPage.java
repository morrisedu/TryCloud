package com.trycloud.pages;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.trycloud.utilities.ConfigReader.readProperty;
import static com.trycloud.utilities.Driver.getDriver;

public class LoginPage {
    @FindBy(id = "user")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit-form")
    private WebElement loginBtn;

    @FindBy(xpath = "//p[contains(@class, 'warning wrongPasswordMsg')]")
    private WebElement loginErrorMessage;

    /**
     * Displayed when too many failed login attempts have been detected
     */
    @FindBy(xpath = "//p[contains(@class, 'warning throttledMsg')]")
    private WebElement throttledErrorMessage;

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public static void goTo() {
        getDriver().get(readProperty("trycloud_url"));
    }

    public  void login(String username, String password) {
        // Open URL
        goTo();

        // Login
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    /**
     * Method to check if login error message is displayed
     * @return boolean, true if it is displayed, otherwise, false
     */
    public boolean isLoginErrorMessageDisplayed(){
        return loginErrorMessage.isDisplayed();
    }

    /**
     * Method to check if throttled error message is displayed
     * @return boolean, true if it is displayed, otherwise, false
     */
    public boolean isThrottledErrorMessageDisplayed() {
        return throttledErrorMessage.isDisplayed();
    }

    /**
     * Method to get the error message displayed on wrong credentials displayed
     * @return stripped error message
     */
    public String getErrorMessage() {
        return loginErrorMessage.getText().strip();
    }

    /**
     * Method to get the throttled error message displayed once too many failed login attempts have been detected
     * @return stripped error message
     */
    public String getThrottledMessage() {
        return throttledErrorMessage.getText().strip();
    }

    public String inputValidation(String input) {
        switch (input) {
            case "username":
                return usernameInput.getAttribute("validationMessage");
            case "password":
                return passwordInput.getAttribute("validationMessage");
        }

        return null;
    }
}
