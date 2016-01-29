package ua.com.anya.GmailTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static ua.com.anya.core.CustomConditions.elementExistsInTheList;
import static ua.com.anya.core.Helpers.assertThat;

public class GmailMails {
    @FindBy(css = "[role='main'] .UI tr")
    public List<WebElement> listOfEmails;

    WebDriver driver;

    public GmailMails(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void send(String to, String subject) {
        driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();
        assertThat(visibilityOfElementLocated(By.name("to")), driver);
        driver.findElement(By.name("to")).sendKeys(to + Keys.ENTER);
        driver.findElement(By.name("subjectbox")).sendKeys(subject);
        driver.findElement(By.xpath("//div[contains(text(), 'Send')]")).click();
        assertThat(visibilityOfElementLocated(By.className("vh")), driver);
    }

    public void searchEmailBySubject(String subject){
        driver.findElement(By.name("q")).sendKeys("subject:" + subject + Keys.ENTER);
    }
    
    public void assertEmailExists(String subject) {
        assertThat(elementExistsInTheList(driver.findElement(By.xpath("//div[contains(text(),'" + subject + "')]")), listOfEmails), driver);
    }

    public void refresh(){
    /*    assertThat(ExpectedConditions.visibilityOfElementLocated(By.className("vh")), driver);
        assertThat(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-tooltip='Refresh']/div")), driver);
        driver.findElement(By.xpath("//div[@data-tooltip='Refresh']/div")).click();*/
        driver.navigate().refresh();
    }

}