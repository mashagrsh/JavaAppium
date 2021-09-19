package lib.ui.mobile_web;

import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWMyListsPageObject extends MyListsPageObject
{
    static {
        ARTICLE_BY_TITLE_TPL = "xpath://ul[contains(@class,'content-unstyled page-list')]//h3[contains(text(),'(TITLE)')]";
        REMOVE_FROM_SAVE_BUTTON = "xpath://ul[contains(@class,'content-unstyled page-list')]//h3[contains(text(),'(TITLE)')]/../../a[contains(@class,'watch-this-article watched')]";
    }

    public MWMyListsPageObject(RemoteWebDriver driver)
    {
        super(driver);
    }
}
