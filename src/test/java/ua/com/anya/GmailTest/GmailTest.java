package ua.com.anya.GmailTest;

import com.codeborne.selenide.Configuration;
import org.junit.Test;
import ua.com.anya.GmailTest.helpers.Config;
import ua.com.anya.GmailTest.pages.Gmail;
import ua.com.anya.GmailTest.pages.GmailMails;
import ua.com.anya.GmailTest.pages.GmailMenu;

import static ua.com.anya.GmailTest.helpers.Helpers.generateUniquePhrase;

public class GmailTest {
    {
        Configuration.timeout = 15000;
    }

    public String subject = generateUniquePhrase("Subject");

    @Test
    public void testGmail() {
        Gmail.open();
        Gmail.login(Config.getUserName(), Config.getPassword());

        GmailMails.send(Config.getUserName(), subject);
        GmailMails.refresh();
        GmailMails.assertEmailExists(subject);

        GmailMenu.openSent();
        GmailMails.assertEmailExists(subject);

        GmailMenu.openInbox();
        GmailMails.searchEmailBySubject(subject);
        GmailMails.listOfEmails.shouldHaveSize(1);
    }
}