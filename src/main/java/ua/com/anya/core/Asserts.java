package ua.com.anya.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Asserts {

    public static void assertThat(ExpectedCondition condition, WebDriver driver){
        new WebDriverWait(driver, Configuration.timeout).until(condition);
    }

    public static void assertThat(ExpectedCondition condition, WebDriver driver, int timeout){
        new WebDriverWait(driver, timeout).until(condition);
    }
}
