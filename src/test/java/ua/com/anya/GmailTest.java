package ua.com.anya;

import org.junit.Test;
import ua.com.anya.core.Configuration;
import ua.com.anya.pages.GmailMailsPage;
import ua.com.anya.pages.GmailMenuPage;
import ua.com.anya.pages.GmailPage;
import ua.com.anya.testData.Authentication;
import ua.com.anya.testconfigs.BaseTest;

import static ua.com.anya.core.CustomConditions.listNthElementHasText;
import static ua.com.anya.core.CustomConditions.textsOf;
import static ua.com.anya.core.Helpers.generateUniquePhrase;
import static ua.com.anya.core.SeleniumHelpers.$;
import static ua.com.anya.core.SeleniumHelpers.assertThat;

public class GmailTest extends BaseTest {
    {
        Configuration.timeout = 4;
    }

    public String subject = generateUniquePhrase("Subject");

    GmailPage gmail = new GmailPage(driver);
    GmailMailsPage mails = new GmailMailsPage(driver);
    GmailMenuPage menu = new GmailMenuPage(driver);

    @Test
    public void testLoginSendMailAndSearchLetter() {
        gmail.ensureIsOpened();
        gmail.login(Authentication.userName, Authentication.password);

        mails.send(Authentication.userName, subject);
        $(mails.emailIsSentMessage, driver);
        mails.refresh();
        assertThat(listNthElementHasText(mails.list, 0, subject), driver);

        menu.openSent();
        assertThat(listNthElementHasText(mails.list, 0, subject), driver);
        mails.searchBySubject(subject);
        assertThat(textsOf(mails.list, subject), driver);
    }
}