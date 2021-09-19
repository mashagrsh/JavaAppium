package lib.ui.IOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.NavigationUI;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSNavigationUI extends NavigationUI
{
    static {
        MY_LISTS_LINK = "//android.widget.FrameLayout[@content-desc='My lists']";
    }

    public IOSNavigationUI(RemoteWebDriver driver)
    {
        super(driver);
    }
}
