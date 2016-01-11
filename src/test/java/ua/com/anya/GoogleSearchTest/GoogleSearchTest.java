package ua.com.anya.GoogleSearchTest;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class GoogleSearchTest {

    @Test
    public void testGoogleSearch() {
        open("http://google.com/ncr");

        searchField.setValue("Selenium automates browsers");
        searchButton.click();
        searchResults.shouldHaveSize(10);

        searchResults.get(0).shouldHave(text("Selenium automates browsers"));

        resultLinks.get(0).click();
        url().contentEquals("http://www.seleniumhq.org/");

    }

    SelenideElement searchField = $("#sb_ifc0 input");
    SelenideElement searchButton = $(".lsb");
    ElementsCollection searchResults = $$("#ires .srg .rc");
    ElementsCollection resultLinks = $$(".r>a");
}
