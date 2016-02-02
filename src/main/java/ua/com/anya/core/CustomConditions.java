package ua.com.anya.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.Arrays;
import java.util.List;

public class CustomConditions{

    public static ExpectedCondition<WebElement> listNthElementHasText(final List<WebElement> elements, final int index, final String expectedText) {
        return new ExpectedCondition<WebElement>() {
            private WebElement element;
            private String actualText;

            public WebElement apply(WebDriver driver) {
                element = elements.get(index);
                actualText = element.getText();
                return element != null && actualText.contains(expectedText)?element:null;
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
                return elements!=null && listSize == expectedSize?elements:null;
            }

            public String toString(){
                return String.format("Actual size of the list is %s,\nexpected size is %s", listSize, expectedSize);
            }
        };
    }

    public static ExpectedCondition<List<WebElement>> textsOf(final List<WebElement> elements, final String... texts) {
        return new ExpectedCondition<List<WebElement>>() {
            private int listSize;

            public List<WebElement> apply(WebDriver driver) {
                listSize = elements.size();
                if (listSize!=texts.length){
                    return null;
                }
                else {
                    for (int i = 0; i < elements.size(); i++) {
                        WebElement element = elements.get(i);
                        String text = texts[i];
                        if (!element.getText().equals(text)) {
                            return null;
                        }
                    }
                    return elements;
                }

            }

            public String webElementsTexts(List<WebElement> list){
                String s = "";
                for (WebElement element: list){
                    s=s+element.getText()+" ";
                }
                return s;
            }

            public String toString(){
                return String.format("Expected texts: %s,\nActual texts: %s", Arrays.toString(texts), webElementsTexts(elements));
            }
        };
    }
}