package ua.com.anya.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.com.anya.core.BasePage;

public class GmailMenuPage extends BasePage {

    public GmailMenuPage(WebDriver driver){
        super(driver);
    }

    public void openInbox(){
        WebElement inbox = $("a[aria-label^='Inbox']");
        inbox.click();
    }

    public void openSent(){
        WebElement sent = $("a[title='Sent Mail']");
        sent.click();
    }
}
