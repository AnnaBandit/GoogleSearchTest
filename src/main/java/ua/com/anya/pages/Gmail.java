package ua.com.anya.pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static ua.com.anya.core.Helpers.assertThat;

public class Gmail {

    @FindBy(id="Email")
    public WebElement loginField;

    @FindBy(id="Passwd")
    public WebElement passwordField;

    @FindBy(xpath="//div[contains(text(), 'COMPOSE')]")
    public WebElement composeButton;

    private WebDriver driver;

    public Gmail(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void ensureIsOpened(){
        if (!"Gmail".equals(driver.getTitle())){
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
