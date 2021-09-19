package lib.ui.IOS;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSMyListsPageObject extends MyListsPageObject
{
    static {
        ARTICLE_BY_TITLE_TPL = "//*[@text='{TITLE}']";
    }

    public IOSMyListsPageObject(RemoteWebDriver driver)
        {
            super(driver);
        }
}
