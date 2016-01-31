package ua.com.anya.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static ua.com.anya.core.Asserts.assertThat;

public class GmailPage extends BasePage{

    @FindBy(id="Email")
    public WebElement loginField;

    @FindBy(id="Passwd")
    public WebElement passwordField;

    @FindBy(xpath="//div[contains(text(), 'COMPOSE')]")
    public WebElement composeButton;

    public GmailPage(WebDriver driver){
        super(driver);
    }

    public void ensureIsOpened(){
        if (!"GmailPage".equals(driver.getTitle())){
            driver.get("http://gmail.com");
        }
    }

    public void login(String userName, String password) {
        loginField.sendKeys(userName + Keys.ENTER);
        assertThat(visibilityOf(passwordField), driver);
        passwordField.sendKeys(password + Keys.ENTER);
        assertThat(visibilityOf(composeButton), driver, 10);
    }
}
