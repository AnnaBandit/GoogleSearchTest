package ua.com.anya.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static ua.com.anya.core.Helpers.assertThat;

public class GmailMails {
    @FindBy(css = "[role='main'] .UI tr")
    public List<WebElement> listOfEmails;

    @FindBy(xpath="//div[contains(text(), 'COMPOSE')]")
    public WebElement composeButton;

    @FindBy(name="to")
    public WebElement sendTo;

    @FindBy(name="subjectbox")
    public WebElement subject;

    @FindBy(xpath="//div[contains(text(), 'Send')]")
    public WebElement sendButton;

    @FindBy(className="vh")
    public WebElement emailIsSentMessage;

    @FindBy(xpath=".//*[@title=\"Refresh\"]")
    public WebElement refreshButton;

    @FindBy(name="q")
    public WebElement searchField;

    private WebDriver driver;

    public GmailMails(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void send(String to, String subj) {
        composeButton.click();
        assertThat(visibilityOf(sendTo), driver);
        sendTo.sendKeys(to + Keys.ENTER);
        subject.sendKeys(subj);
        sendButton.click();
        assertThat(visibilityOf(emailIsSentMessage), driver);
    }

    public void searchEmailBySubject(String subject){
        searchField.sendKeys("subject:" + subject + Keys.ENTER);
    }

    public void refresh(){
        assertThat(ExpectedConditions.visibilityOf(refreshButton), driver);
        refreshButton.click();
    }
}