package ua.com.anya.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static ua.com.anya.core.Asserts.assertThat;

public class WebElements {

    public static WebElement $(WebElement element, WebDriver driver){
        return assertThat(visibilityOf(element), driver);
    }

    public static WebElement $(By locator, WebDriver driver){
        return assertThat(visibilityOfElementLocated(locator), driver);
    }

    public static WebElement $(String cssSelector, WebDriver driver){
        return assertThat(visibilityOfElementLocated(By.cssSelector(cssSelector)), driver);
    }
}
