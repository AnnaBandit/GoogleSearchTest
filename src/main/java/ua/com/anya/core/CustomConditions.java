package ua.com.anya.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public static ExpectedCondition<Boolean> listHasSizeMoreThan(final List<WebElement> elements, final int size) {
        return new ExpectedCondition<Boolean>() {
            private int actualSize;

            public Boolean apply(WebDriver driver) {
                try {
                    actualSize = elements.size();
                    return elements.size()>size;
                } catch (IndexOutOfBoundsException ex) {
                    return false;
                }
            }

            public String toString(){
                return String.format("Actual list size is %s, expected size is not less than %s", actualSize, size);
            }
        };
    }

    public static ExpectedCondition<Boolean> elementExistsInTheList(final WebElement element, final List<WebElement> elements) {
        return new ExpectedCondition<Boolean>() {
            private boolean exists = false;

            public Boolean apply(WebDriver driver) {
                while (exists == false) {
                    for (WebElement el : elements) {
                        if (el.equals(element)) {
                            exists = true;
                        }
                    }
                }

                return exists;
            }

          /*  public String toString(){
                return String.format("Actual size of the list is %s,\nexpected size is %s", listSize, expectedSize);
            }*/
        };
    }

}