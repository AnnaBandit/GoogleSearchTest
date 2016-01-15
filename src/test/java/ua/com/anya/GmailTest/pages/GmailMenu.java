package ua.com.anya.GmailTest.pages;

import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.$;

public class GmailMenu {
    public static void openInbox(){
        $("a[aria-label^='Inbox']").click();
    }

    public static void openSent(){
        $(byTitle("Sent Mail")).click();
    }
}
