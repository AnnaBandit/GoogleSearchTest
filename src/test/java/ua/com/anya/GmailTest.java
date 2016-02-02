package ua.com.anya;

import org.junit.Test;
import ua.com.anya.core.Configuration;
import ua.com.anya.pages.GmailMailsPage;
import ua.com.anya.pages.GmailMenuPage;
import ua.com.anya.pages.GmailPage;
import ua.com.anya.testData.Authentication;
import ua.com.anya.testconfigs.BaseTest;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static ua.com.anya.core.Asserts.assertThat;
import static ua.com.anya.core.CustomConditions.listNthElementHasText;
import static ua.com.anya.core.CustomConditions.textsOf;
import static ua.com.anya.core.Helpers.generateUniquePhrase;

public class GmailTest extends BaseTest {
    {
        Configuration.timeout = 4;
    }

    public String subject = generateUniquePhrase("Subject");

    GmailPage gmail = new GmailPage(driver);
    GmailMailsPage gmailMails = new GmailMailsPage(driver);
    GmailMenuPage gmailMenu = new GmailMenuPage(driver);

    @Test
    public void testLoginSendMailAndSearchLetter() {
        gmail.ensureIsOpened();
        gmail.login(Authentication.userName, Authentication.password);

        gmailMails.send(Authentication.userName, subject);
        assertThat(visibilityOf(gmailMails.emailIsSentMessage), driver);
        gmailMails.refresh();
        assertThat(listNthElementHasText(gmailMails.list, 0, subject), driver);

        gmailMenu.openSent();
        assertThat(listNthElementHasText(gmailMails.list, 0, subject), driver);
        gmailMails.searchEmailBySubject(subject);
        assertThat(textsOf(gmailMails.list, subject), driver);
    }
}