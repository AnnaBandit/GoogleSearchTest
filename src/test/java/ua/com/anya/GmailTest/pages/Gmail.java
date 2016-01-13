package ua.com.anya.GmailTest.pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class Gmail {

    public Gmail(){
        open("http://gmail.com");
    }

    public ElementsCollection listOfEmails = $$(".y6");

    public void login(String userName, String password) {
        $("#Email").setValue(userName).pressEnter();
        $("#Passwd").setValue(password).pressEnter();
    }

    public void sendEmail(String to, String subject) {
        $(byText("COMPOSE")).click();
        $(By.name("to")).setValue(to).pressEnter();
        $(By.name("subjectbox")).setValue(subject).pressEnter();
        $(byText("Send")).click();
    }

    public void refresh(){
        $(by("title", "Refresh")).click();
    }

    public void searchEmail(String text){
        $(By.name("q")).setValue(text).pressEnter();
    }

    public void assertOnlyOneEmailWithSpecifiedTextIsReceived(String text){
        assertEquals(1, $$(listOfEmails.filterBy(exactText(text))).size());
    }

    public void assertEmailReceived(String text) {
        listOfEmails.findBy(exactText(text)).exists();
    }

    public void assertEmailExistsInSent(String emailTitle){
        $(byText("Sent Mail")).click();
        listOfEmails.findBy(exactText(emailTitle)).shouldBe(visible);
    }
}
