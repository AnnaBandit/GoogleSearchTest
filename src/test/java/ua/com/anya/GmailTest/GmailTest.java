package ua.com.anya.GmailTest;

import org.junit.Test;
import ua.com.anya.GmailTest.pages.Gmail;
import ua.com.anya.GmailTest.testconfigs.Config;

import static com.codeborne.selenide.Configuration.timeout;
import static com.codeborne.selenide.Selenide.open;

public class GmailTest {
    static {
        timeout = 15000;
    }

    public String emailTitle = Long.toString(System.currentTimeMillis());
    Gmail gmail = new Gmail();

    @Test
    public void testGmail() {
        gmail.login(Config.getUserName(), Config.getPassword());

        gmail.sendEmail(Config.getUserName() + "@gmail.com", emailTitle);
        gmail.refresh();
        gmail.assertEmailReceived(emailTitle);
        gmail.assertEmailExistsInSent(emailTitle);

        //что-то никак не получилось локатор подобрать(
        open("https://mail.google.com/mail/#inbox");
        gmail.searchEmail(emailTitle);
        gmail.assertOnlyOneEmailWithSpecifiedTextIsReceived(emailTitle);
    }
}