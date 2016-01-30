package ua.com.anya;

import org.junit.Test;
import ua.com.anya.core.Configuration;
import ua.com.anya.helpers.Config;
import ua.com.anya.pages.Gmail;
import ua.com.anya.pages.GmailMails;
import ua.com.anya.pages.GmailMenu;
import ua.com.anya.testconfigs.BaseTest;

import static ua.com.anya.core.CustomConditions.listNthElementHasText;
import static ua.com.anya.core.CustomConditions.sizeOf;
import static ua.com.anya.core.Helpers.assertThat;
import static ua.com.anya.core.Helpers.generateUniquePhrase;

public class GmailTest extends BaseTest {
    {
        Configuration.timeout = 4;
    }

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
        assertThat(listNthElementHasText(gmailMails.listOfEmails, 0, subject), driver);


        gmailMenu.openSent();
        assertThat(listNthElementHasText(gmailMails.listOfEmails, 0, subject), driver);
        gmailMenu.openInbox();
        gmailMails.searchEmailBySubject(subject);
        assertThat(sizeOf(gmailMails.listOfEmails, 1), driver);
    }
}