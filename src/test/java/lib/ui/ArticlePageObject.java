package lib.ui;

import lib.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject {

    protected static String TITLE;
    protected static String FOOTER_ELEMENT;
    protected static String OPTIONS_BUTTON;
    protected static String OPTIONS_ADD_TO_MY_LIST_BUTTON;
    protected static String OPTIONS_REMOVE_FROM_MY_LIST_BUTTON;
    protected static String ADD_TO_MY_LIST_OVERLAY;
    protected static String MY_LIST_NAME_INPUT;
    protected static String MY_LIST_OK_BUTTON;
    protected static String CLOSE_ARTICLE_BUTTON;
    protected static String TITLE_WITH_NAME_TPL;
    protected static String MY_LIST_NAME;
    protected static String HEADER;


    public ArticlePageObject (RemoteWebDriver driver)
    {
        super(driver);
    }

    /* TEMPLATES METHODS */
    private static String getResultArticleTitle(String article_title)
    {
        return TITLE_WITH_NAME_TPL.replace("(TITLE)", article_title);
    }
    /* TEMPLATES METHODS */

    public WebElement waitForTitleElement()
    {
        return this.waitForElementPresent(TITLE, "Cannot find article title", 15);
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid()){
            return title_element.getAttribute("text");
        } else if (Platform.getInstance().isIOS()){
            return title_element.getAttribute("name");
        } else {
            return title_element.getText();
        }
    }

    public void swipeToFooter()
    {
        if (Platform.getInstance().isAndroid()){
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    20
            );
        } else {
            this.scrollWebPageTillElementNotVisible(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    20
            );
        }

    }

    public void addArticleToMyNewList(String name_of_folder)
    {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button 'More options'",
                5
        );

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find button 'Add to reading list'",
                5
        );

        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find button 'Got it'",
                5
        );

        this.waitForElementAndClear(
                MY_LIST_NAME_INPUT,
                "Cannot find text input",
                1
        );

        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot put text into article input",
                1
        );

        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot press 'OK' button",
                5
        );
    }

    public void addArticleToMyOldList()
    {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button 'More options'",
                5
        );

        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find button 'Add to reading list'",
                5
        );

        this.waitForElementAndClick(
                MY_LIST_NAME,
                "Cannot find list",
                5
        );
    }

    public void removeArticleFromMyList()
    {
        if (this.isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON)){
            this.waitForElementAndClick(
                    OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
                    "Cannot remove old article from list",
                    1
            );
            this.waitForElementPresent(
                    OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
                    "Cannot find button to save the new article"
            );
        }
    }

    public void closeArticle()
    {
        if (Platform.getInstance().isAndroid() || Platform.getInstance().isIOS()){
            this.waitForElementAndClick(
                    CLOSE_ARTICLE_BUTTON,
                    "Cannot close article, cannot find X link",
                    5
            );
        } else {
            System.out.println("Method closeArticle() does nothing for platform " + Platform.getInstance().getPlatformVar());
        }

    }

    public void clickToArticleWithTitle(String article_title)
    {
        String article_title_xpath = getResultArticleTitle(article_title);
        this.waitForElementAndClick(article_title_xpath, "Cannot find and click article with title",10);
    }

    public WebElement waitForArticleHeader()
    {
        return this.waitForElementPresent(HEADER, "Cannot find article header", 15);
    }

    public void assertThereIsSomeResultOfSearch()
    {
        this.assertElementPresent(TITLE, "We supposed find any results");
    }

    public void addArticlesToMySaved()
    {
        if (Platform.getInstance().isMW()){
            this.removeArticleFromMyList();
        }

        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Cannot find the option to add article", 5);
    }
}
