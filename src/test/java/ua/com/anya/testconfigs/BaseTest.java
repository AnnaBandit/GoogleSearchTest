package ua.com.anya.testconfigs;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ua.com.anya.core.Configuration;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    {
        Configuration.timeout = 10;
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    public static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        driver = new FirefoxDriver();
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

}
