package ua.com.anya.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class SeleniumHelpers<T> {

    public static <V> V assertThat(ExpectedCondition<V> condition, WebDriver driver){
        return new WebDriverWait(driver, Configuration.timeout).until(condition);
    }

    public static <V> V assertThat(ExpectedCondition<V> condition, WebDriver driver, int timeout){
        return new WebDriverWait(driver, timeout).until(condition);
    }

    public static WebElement $(WebElement element, WebDriver driver){
        return assertThat(visibilityOf(element), driver);
    }

    public static WebElement $(By locator, WebDriver driver){
        return assertThat(visibilityOfElementLocated(locator), driver);
    }

    public static WebElement $(String cssSelector, WebDriver driver){
        return assertThat(visibilityOfElementLocated(By.cssSelector(cssSelector)), driver);
    }

    public static List<WebElement> $$(String cssSelector, WebDriver driver){
        return driver.findElements(byCss(cssSelector));
    }

    public static List<WebElement> $$(By locator, WebDriver driver){
        return driver.findElements(locator);
    }

    public static By byCss(String cssSelector){
        return By.cssSelector(cssSelector);
    }

    public static ExpectedCondition <WebElement> visible(final WebElement element) {
        return ExpectedConditions.visibilityOf(element);
    }

}
