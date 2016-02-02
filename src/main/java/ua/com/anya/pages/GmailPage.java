package ua.com.anya.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ua.com.anya.core.BasePage;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static ua.com.anya.core.Asserts.assertThat;

public class GmailPage extends BasePage {

    @FindBy(id="Email")
    public WebElement loginField;

    @FindBy(id="Passwd")
    public WebElement passwordField;

    public GmailPage(WebDriver driver){
        super(driver);
    }

    public void ensureIsOpened(){
        if (!"GmailPage".equals(driver.getTitle())){
            driver.get("http://gmail.com");
        }
    }

    public void login(String userName, String password) {
        assertThat(visibilityOf(loginField), driver).sendKeys(userName + Keys.ENTER);
        assertThat(visibilityOf(passwordField), driver).sendKeys(password + Keys.ENTER);
    }
}
