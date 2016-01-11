package ua.com.anya.GoogleSearchTest;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertEquals;

public class GoogleSearchTest {

    @Test
    public void testGoogleSearch() {
        open("http://google.com/ncr");

        searchField.setValue("Selenium automates browsers");
        searchButton.click();
        searchResults.shouldHaveSize(10);

        searchResults.get(0).shouldHave(text("Selenium automates browsers"));

        resultLinks.get(0).click();

        headerLinkOnSeleniumPage.shouldHave(exactText("Browser Automation"));
        assertEquals("http://www.seleniumhq.org/", url() );
        
    }

    SelenideElement searchField = $("#sb_ifc0 input");
    SelenideElement searchButton = $(".lsb");
    SelenideElement headerLinkOnSeleniumPage = $("#header h1 a");
    ElementsCollection searchResults = $$("#ires .srg .rc");
    ElementsCollection resultLinks = $$(".r>a");
}
