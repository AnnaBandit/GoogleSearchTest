package ua.com.anya.core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

public class CustomConditions{

    public static ExpectedCondition<Boolean> listNthElementHasText(final List<WebElement> elements, final int index, final String expectedText) {
        return new ExpectedCondition<Boolean>() {
            private String actualText;

            public Boolean apply(WebDriver driver) {
                try {
                    actualText = elements.get(index).getText();
                    return actualText.contains(expectedText);
                } catch (IndexOutOfBoundsException ex) {
                    return false;
                }
            }

            public String toString() {
                return String.format("Actual text on %s element is %s, \nExpected text is %s", index, actualText, expectedText);
            }
        };
    }

    public static ExpectedCondition<Boolean> sizeOf(final List<WebElement> elements, final int expectedSize) {
        return new ExpectedCondition<Boolean>() {
            private int listSize;

            public Boolean apply(WebDriver driver) {
                listSize = elements.size();
                return listSize == expectedSize;
            }

            public String toString(){
                return String.format("Actual size of the list is %s,\nexpected size is %s", listSize, expectedSize);
            }
        };
    }

    public static ExpectedCondition<Boolean> listElementHasText(final List<WebElement> elements, final String expectedText) {
        return new ExpectedCondition<Boolean>() {
            private String actualText;
            private boolean isPresent = false;

            public Boolean apply(WebDriver driver) {
                for (int i=0; i<elements.size(); i++){
                    actualText = elements.get(i).getText();
                    if (actualText.contains(expectedText)){
                        isPresent=true;
                        break;
                    }
                }
                return isPresent;
            }

            public String toString(){
                return String.format("No element in the list has text %s", expectedText);
            }
        };
    }
}