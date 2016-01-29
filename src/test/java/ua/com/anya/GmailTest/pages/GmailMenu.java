package ua.com.anya.GmailTest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GmailMenu {

    WebDriver driver;

    public GmailMenu(WebDriver driver){
        this.driver = driver;
    }

    public void openInbox(){
        driver.findElement(By.cssSelector("a[aria-label^='Inbox']")).click();
    }

    public void openSent(){
        driver.findElement(By.cssSelector("a[title='Sent Mail']")).click();
    }
}