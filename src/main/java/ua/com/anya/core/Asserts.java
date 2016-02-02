package ua.com.anya.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Asserts <T> {

    public static <T> T assertThat(ExpectedCondition<T> condition, WebDriver driver){
        return new WebDriverWait(driver, Configuration.timeout).until(condition);
    }

    public static <T> T assertThat(ExpectedCondition<T> condition, WebDriver driver, int timeout){
        return new WebDriverWait(driver, timeout).until(condition);
    }

}
