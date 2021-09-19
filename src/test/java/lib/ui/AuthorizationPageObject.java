package lib.ui;

import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObject extends MainPageObject
{
    private static final String
        LOGIN_BUTTON = "xpath://body/div/div/a[text()='Log in']",
        LOGIN_INPUT = "css:input[name=wpName]",
        PASSWORD_INPUT = "css:input[name=wpPassword]",
        SUBMIT_BUTTON = "css:button#wpLoginAttempt";

    public AuthorizationPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }

    public void clickAuthButton()
    {
        this.waitForElementPresent(LOGIN_BUTTON, "There is no login button", 20);
        this.waitForElementAndClick(LOGIN_BUTTON, "There is no login input for clicking", 5);
    }

    public void enterLoginData(String login, String password)
    {
        this.waitForElementAndSendKeys(LOGIN_INPUT, login, "Cannot find and put login", 5);
        this.waitForElementAndSendKeys(PASSWORD_INPUT, password, "Cannot find and put password", 5);
    }

    public void submitForm()
    {
        this.waitForElementAndClick(SUBMIT_BUTTON,"Cannot find submit button", 5);
    }
}
