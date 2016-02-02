package ua.com.anya.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomConditions{

    public static ExpectedCondition<WebElement> listNthElementHasText(final List<WebElement> elements, final int index, final String expectedText) {
        return new ExpectedCondition<WebElement>() {
            private WebElement element;
            private String actualText;

            public WebElement apply(WebDriver driver) {
                try {
                    element = elements.get(index);
                    actualText = element.getText();
                    return element.getText().contains(expectedText)?element : null;
                } catch (IndexOutOfBoundsException ex){
                    return null;
                }
            }

            public String toString() {
                return String.format("Actual text on %s element is %s, \nExpected text is %s", index, actualText, expectedText);
            }
        };
    }

    public static ExpectedCondition<List<WebElement>> sizeOf(final List<WebElement> elements, final int expectedSize) {
        return new ExpectedCondition<List<WebElement>>() {
            private int listSize;

            public List<WebElement> apply(WebDriver driver) {
                listSize = elements.size();
                return elements.size() == expectedSize?elements:null;
            }

            public String toString(){
                return String.format("Actual size of the list is %s,\nexpected size is %s", listSize, expectedSize);
            }
        };
    }

    public static ExpectedCondition<List<WebElement>> textsOf(final List<WebElement> elements, final String... texts) {
        return new ExpectedCondition<List<WebElement>>() {
            private int listSize;
            private List<String> actualTexts;

            public List<WebElement> apply(WebDriver driver) {
                listSize = elements.size();
                if (listSize!=texts.length){
                    return null;
                }
                else {
                    actualTexts = new ArrayList<String>(elements.size());
                    for (int i = 0; i < elements.size(); i++) {
                        actualTexts.add(elements.get(i).getText());
                    }

                    for (int i = 0; i < elements.size(); i++) {
                        String actualText = actualTexts.get(i);
                        if (!actualText.contains(texts[i])) {
                            return null;
                        }
                    }
                    return elements;
                }

            }

            private String webElementsTexts(List<String> actualTexts){
                String s = "";
                for (String text: actualTexts){
                    s+=text+" ";
                }
                return s;
            }

            public String toString(){
                return String.format("Expected texts: %s,\nActual texts: %s", Arrays.toString(texts), webElementsTexts(actualTexts));
            }
        };
    }
}