package ua.com.anya.GoogleSearchTest;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;

public class GoogleSearchTest {

    @Test
    public void testGoogleSearch() {
        open("http://google.com/ncr");

        searchField.setValue("Selenium automates browsers").pressEnter();
        searchResults.shouldHaveSize(10);
        searchResults.get(0).shouldHave(text("Selenium automates browsers"));

        searchResults.get(0).find(".r>a").click();

        headerLinkOnSeleniumPage.shouldHave(exactText("Browser Automation"));
        assertEquals("http://www.seleniumhq.org/", url());
    }

    SelenideElement searchField = $("#lst-ib");
    ElementsCollection searchResults = $$(".srg .rc");
    SelenideElement headerLinkOnSeleniumPage = $("#header h1 a");
}
