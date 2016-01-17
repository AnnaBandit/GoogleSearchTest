package ua.com.anya.GmailTest.pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GmailMails {
    public static ElementsCollection listOfEmails = $$(".UI tr").filter(visible);

    public static void send(String to, String subject) {
        $(byText("COMPOSE")).click();
        $(By.name("to")).setValue(to).pressEnter();
        $(By.name("subjectbox")).setValue(subject).pressEnter();
        $(byText("Send")).click();
    }

    public static void searchEmailBySubject(String subject){
        $(By.name("q")).setValue("subject:" + subject).pressEnter();
    }

    public static void assertEmailExists(String subject) {
        listOfEmails.findBy(text(subject)).exists();
    }

    public static void refresh(){
        $(byTitle("Refresh")).click();
    }

}
