package ua.com.anya.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailMenu {

    @FindBy(css="a[aria-label^='Inbox']")
    public WebElement inbox;

    @FindBy(css="a[title='Sent Mail']")
    public WebElement sent;

    private WebDriver driver;

    public GmailMenu(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void openInbox(){
        inbox.click();
    }

    public void openSent(){
        sent.click();
    }
}