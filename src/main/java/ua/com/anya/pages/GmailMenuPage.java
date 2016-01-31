package ua.com.anya.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailMenuPage extends BasePage{

    @FindBy(css="a[aria-label^='Inbox']")
    public WebElement inbox;

    @FindBy(css="a[title='Sent Mail']")
    public WebElement sent;

    public GmailMenuPage(WebDriver driver){
        super(driver);
    }

    public void openInbox(){
        inbox.click();
    }

    public void openSent(){
        sent.click();
    }
}