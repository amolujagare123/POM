package UITesting;

import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Login;
import util.OpenUrl;

import static util.UITestUtil.*;

public class LoginTest extends OpenUrl {
    Login login;

    @BeforeClass
    public void initLogin()
    {
        login = new Login(driver);
    }

    /*@Test
    public void txtUsernameVisibilityCheck()
    {
        boolean expected = true;
        boolean actual = false;
        try {
             actual = login.txtUsername.isDisplayed();
        }
        catch(Exception e)
        {

        }
        Assert.assertEquals(actual,expected,"username textbox element is not present");
    }*/

    @Test
    public void txtUsernameVisibilityCheck()
    {
        boolean expected = true;
        boolean actual = checkVisibility(login.txtUsername);
        Assert.assertEquals(actual,expected,
                "username textbox element is not present");
    }

    @Test
    public void txtPasswordVisibilityCheck()
    {
        boolean expected = true;
        boolean actual = checkVisibility(login.txtPassword);
        Assert.assertEquals(actual,expected,
                "password textbox element is not present");
    }

    @Test
    public void lblEmailSpellCheck()
    {
        String expected = "Email";
        String actual = checkText(login.lblEmail);
        Assert.assertEquals(actual,expected,
                "incorrect spelling");
    }

    @Test
    public void lblPasswordSpellCheck()
    {
        String expected = "Password";
        String actual = checkText(login.lblPassword);
        Assert.assertEquals(actual,expected,
                "incorrect spelling");
    }

    @Test
    public void placeholderPasswordCheck()
    {
        String expected = "Password";
        String actual = checkPlaceholder(login.txtPassword);
        Assert.assertEquals(actual,expected,
                "Incorrect Placeholder");
    }

    @Test
    public void placeholderEmailCheck()
    {
        String expected = "Email";
        String actual = checkPlaceholder(login.txtUsername);
        Assert.assertEquals(actual,expected,
                "Incorrect Placeholder");
    }

    @Test
    public void lblEmailFontSizeCheck()
    {
        String expected = "14px";
        String actual = checkCSSProperty(login.lblEmail,"font-size");
        Assert.assertEquals(actual,expected,
                "Incorrect Font");
    }

    @Test
    public void lblEmailFontFamilyCheck()
    {
        String expected = "-apple-system, system-ui, BlinkMacSystemFont, \"Segoe UI\", Roboto, \"Helvetica Neue\", Arial, sans-serif";
        String actual = checkCSSProperty(login.lblEmail,"font-family");
        Assert.assertEquals(actual,expected,
                "Incorrect font family");
    }

    @Test
    public void btnLoginColorCheck()
    {
        String expected = "#2C8EDD";
        String elementColor = checkCSSProperty(login.btnLogin,"background-color");

        String actual = Color.fromString(elementColor).asHex().toUpperCase();

        Assert.assertEquals(actual,expected,
                "Incorrect color");
    }




}
