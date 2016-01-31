package ua.com.anya;

import org.junit.Test;
import ua.com.anya.core.Configuration;
import ua.com.anya.testData.Authentication;
import ua.com.anya.pages.GmailMailsPage;
import ua.com.anya.pages.GmailMenuPage;
import ua.com.anya.pages.GmailPage;
import ua.com.anya.testconfigs.BaseTest;

import static ua.com.anya.core.Asserts.assertThat;
import static ua.com.anya.core.CustomConditions.*;
import static ua.com.anya.core.Helpers.generateUniquePhrase;
import static ua.com.anya.pages.GmailMailsPage.MailFolders.INBOX;
import static ua.com.anya.pages.GmailMailsPage.MailFolders.SENT;

public class GmailTest extends BaseTest {
    {
        Configuration.timeout = 4;
    }

    public String subject = generateUniquePhrase("Subject");

    GmailPage gmail = new GmailPage(driver);
    GmailMailsPage gmailMails = new GmailMailsPage(driver);
    GmailMenuPage gmailMenu = new GmailMenuPage(driver);

    @Test
    public void testLoginToGmailSendAndGetLetter() {
        gmail.ensureIsOpened();
        gmail.login(Authentication.userName, Authentication.password);

        gmailMails.send(Authentication.userName, subject);
        gmailMails.refresh();
        assertThat(listNthElementHasText(gmailMails.list, 0, subject), driver);

        gmailMails.searchEmailBySubject(subject, SENT);
        assertThat(listNthElementHasText(gmailMails.list, 0, subject), driver);
        gmailMails.searchEmailBySubject(subject, INBOX);
        assertThat(listNthElementHasText(gmailMails.list, 0, subject), driver);
        assertThat(sizeOf(gmailMails.list, 1), driver);
    }
}