package ua.com.anya.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.com.anya.core.BasePage;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static ua.com.anya.core.Asserts.assertThat;

public class GmailMailsPage extends BasePage {
    @FindBy(css = "[role='main'] .UI tr")
    public List<WebElement> list;

    @FindBy(css = "[role='main'] .UI tr .y6")
    public List<WebElement> listOfSubjectsWithStartOfTheLetter;

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

    public GmailMailsPage(WebDriver driver){
        super(driver);
    }

    public void send(String to, String subj) {
        assertThat(visibilityOf(composeButton), driver).click();
        assertThat(visibilityOf(sendTo), driver).sendKeys(to + Keys.ENTER);
        subject.sendKeys(subj);
        sendButton.click();
        assertThat(visibilityOf(emailIsSentMessage), driver);
    }

    public void searchEmailBySubject(String subject){
        searchField.clear();
        searchField.sendKeys("subject:" + subject + Keys.ENTER);
    }

    public void refresh(){
        assertThat(visibilityOf(refreshButton), driver).click();
    }
}