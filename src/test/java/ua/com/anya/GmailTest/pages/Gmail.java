package ua.com.anya.GmailTest.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static ua.com.anya.core.Helpers.assertThat;

public class Gmail {

    private WebDriver driver;

    public Gmail(WebDriver driver){
        this.driver = driver;
    }

    public void ensureIsOpened(){
        if (!"Gmail".equals(driver.getTitle())){
            driver.get("http://gmail.com");
        }
    }

    public void login(String userName, String password) {
        driver.findElement(By.id("Email")).sendKeys(userName + Keys.ENTER);
        assertThat(visibilityOfElementLocated(By.id("Passwd")), driver);
        driver.findElement(By.id("Passwd")).sendKeys(password + Keys.ENTER);
        assertThat(visibilityOfElementLocated(By.xpath("//div[contains(text(), 'COMPOSE')]")), driver);
    }
}
