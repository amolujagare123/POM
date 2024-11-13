package util;

import org.openqa.selenium.WebElement;

public class UITestUtil {

    public static boolean checkVisibility(WebElement element)
    {
        boolean result = false;
        try {
            result = element.isDisplayed();
        }
        catch(Exception e)
        {

        }
        return result;
    }

    public static String checkText(WebElement element)
    {
        String result = "";
        try {
            result = element.getText();
        }
        catch(Exception e)
        {

        }
        return result;
    }

    public static String checkPlaceholder(WebElement element)
    {
        String result = "";
        try {
            result = element.getAttribute("placeholder");
        }
        catch(Exception e)
        {

        }
        return result;
    }

    public static String checkCSSProperty(WebElement element,String propertyName)
    {
        String result = "";
        try {
            result = element.getCssValue(propertyName);
        }
        catch(Exception e)
        {

        }
        return result;
    }
}
