package ua.com.anya.pages;

import org.openqa.selenium.WebDriver;
import ua.com.anya.core.BasePage;

import static ua.com.anya.core.SeleniumHelpers.$;
import static ua.com.anya.core.SeleniumHelpers.byCss;

public class GmailMenuPage extends BasePage {

    public GmailMenuPage(WebDriver driver){
        super(driver);
    }

    public void openInbox(){
        $(byCss("a[aria-label^='Inbox']"), driver).click();
    }

    public void openSent(){
        $(byCss("a[title='Sent Mail']"), driver).click();
    }
}
