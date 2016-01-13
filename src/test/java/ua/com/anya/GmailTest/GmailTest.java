package ua.com.anya.GmailTest;

import com.codeborne.selenide.SelenideElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class GmailTest_ {

    @Before
    public void openGmailPage() {
        open("http://gmail.com");
    }

    @After
    public void clearTestData() {
        selectAllEmails.click();
        removeButton.click();
    }

    @Test
    public void testGoogleSearch() {

        loginToGmail(Config.getUserName(), Config.getPassword());
        timeout = 15000;

        sendEmail(Config.getUserName() + "@gmail.com", testText);
        timeout = 10000;
        checkEmailReceived();

        sentMail.click();
        assertEmailExists(testText);

        inboxWithOneEmailReceived.click();
        assertNumberOfEmailsFoundByText(testText, 1);
    }

    SelenideElement sentMail = $(byText("Sent Mail"));
    SelenideElement inboxWithOneEmailReceived = $(byText("Inbox (1)"));
    String testText = "Test Email";
    SelenideElement removeButton = $$(".asa").get(2);
    SelenideElement selectAllEmails = $(".T-Jo-auh");

    public void loginToGmail(String userName, String password) {
        $("#Email").setValue(userName).pressEnter();
        $("#Passwd").setValue(password).pressEnter();
    }

    public void sendEmail(String to, String subject) {
        composeEmail();
        setRecipient(to);
        setSubject(subject);
        sendEmail();
    }

    public void composeEmail() {
        $(byText("COMPOSE")).click();
    }

    public void setRecipient(String to) {
        $(By.name("to")).setValue(to).pressEnter();
    }

    public void setSubject(String subject) {
        $(By.name("subjectbox")).setValue(subject).pressEnter();
    }

    public void sendEmail() {
        $(byText("Send")).click();
    }

    public void assertNumberOfEmailsFoundByText(String text, int number) {
        $(By.name("q")).setValue(text).pressEnter();
        assertTrue(number == $$(By.className("Cp")).filterBy(text(text)).size());
    }

    public void assertEmailExists(String text) {
        $(byText(text)).exists();
    }

    public void checkEmailReceived() {
        inboxWithOneEmailReceived.shouldBe(visible);
    }
}