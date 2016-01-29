package ua.com.anya.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static ua.com.anya.core.CustomConditions.listHasSizeMoreThan;

public class Helpers {

    public static void assertThat(ExpectedCondition condition, WebDriver driver){
        new WebDriverWait(driver, Configuration.timeout).until(condition);
    }

    public static void assertThat(ExpectedCondition condition, WebDriver driver, int timeout){
        new WebDriverWait(driver, timeout).until(condition);
    }

    public static WebElement get(List<WebElement> elements, int index, WebDriver driver) {
        return get(elements, index, driver, Configuration.timeout);
    }

    public static WebElement get(List<WebElement> elements, int index, WebDriver driver, int timeout) {
        assertThat(listHasSizeMoreThan(elements, index), driver, timeout);
        return elements.get(index);
    }

    public static String generateUniquePhrase(String prefix){
        return prefix + Long.toString(System.currentTimeMillis());
    }
}
