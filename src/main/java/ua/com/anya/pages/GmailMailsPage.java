package ua.com.anya.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import ua.com.anya.core.BasePage;

import static ua.com.anya.core.SeleniumHelpers.$;
import static ua.com.anya.core.SeleniumHelpers.byCss;

public class GmailMailsPage extends BasePage {
    public By list = byCss("[role='main'] .UI tr");
    public By emailIsSentMessage = By.className("vh");

    public GmailMailsPage(WebDriver driver){
        super(driver);
    }

    public void send(String to, String subj) {
        $(By.xpath("//div[contains(text(), 'COMPOSE')]"), driver).click();
        $(By.name("to"), driver).sendKeys(to + Keys.ENTER);
        $(By.name("subjectbox"), driver).sendKeys(subj);
        $(By.xpath("//div[contains(text(), 'Send')]"), driver).click();
    }

    public void searchBySubject(String subject){
        $(By.name("q"), driver).clear();
        $(By.name("q"), driver).sendKeys("subject:" + subject + Keys.ENTER);
    }

    public void refresh(){
        $(By.xpath(".//*[@title=\"Refresh\"]"), driver).click();
    }
}