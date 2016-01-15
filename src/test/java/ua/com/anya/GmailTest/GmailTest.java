package ua.com.anya.GmailTest;

import com.codeborne.selenide.Configuration;
import org.junit.Test;
import ua.com.anya.GmailTest.helpers.Config;

import static ua.com.anya.GmailTest.helpers.Helpers.generateUniqueSubjectWithSetText;
import static ua.com.anya.GmailTest.pages.Gmail.*;
import static ua.com.anya.GmailTest.pages.GmailMails.*;
import static ua.com.anya.GmailTest.pages.GmailMenu.*;

public class GmailTest {
    {
        Configuration.timeout = 15000;
    }

    public String subject = generateUniqueSubjectWithSetText("Subject");

    @Test
    public void testGmail() {
        openGmail();
        login(Config.getUserName(), Config.getPassword());

        sendEmail(Config.getUserName(), subject);
        refresh();
        assertEmailExists(subject);

        openSent();
        assertEmailExists(subject);

        openInbox();
        searchEmailBySubject(subject);
        assertOnlyOneEmailWithSpecifiedSubjectIsReceived(subject);
    }
}