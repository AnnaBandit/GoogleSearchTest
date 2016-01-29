package ua.com.anya.GmailTest;

import org.junit.Test;
import ua.com.anya.GmailTest.helpers.Config;
import ua.com.anya.GmailTest.pages.Gmail;
import ua.com.anya.GmailTest.pages.GmailMails;
import ua.com.anya.GmailTest.pages.GmailMenu;
import ua.com.anya.GmailTest.testconfigs.BaseTest;
import ua.com.anya.core.Configuration;

import static ua.com.anya.core.CustomConditions.sizeOf;
import static ua.com.anya.core.Helpers.assertThat;
import static ua.com.anya.core.Helpers.generateUniquePhrase;

public class GmailTest extends BaseTest{
    {
        Configuration.timeout = 4;
    }

    //WebDriverWait wait = new WebDriverWait(driver, 4);

    public String subject = generateUniquePhrase("Subject");

    Gmail gmail = new Gmail(driver);
    GmailMails gmailMails = new GmailMails(driver);
    GmailMenu gmailMenu = new GmailMenu(driver);

    @Test
    public void testGmail() {
        gmail.ensureIsOpened();

        gmail.login(Config.getUserName(), Config.getPassword());

        gmailMails.send(Config.getUserName(), subject);
        gmailMails.refresh();
        gmailMails.assertEmailExists(subject);

        gmailMenu.openSent();
        gmailMails.assertEmailExists(subject);

        gmailMenu.openInbox();
        gmailMails.searchEmailBySubject(subject);
        assertThat(sizeOf(gmailMails.listOfEmails, 1), driver);
    }
}