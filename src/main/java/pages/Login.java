package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    @FindBy(id = "email")
    WebElement txtUsername;

    @FindBy(id = "password")
    WebElement txtPassword;

    @FindBy(xpath="//button[@type='submit']")
    WebElement btnLogin;

    @FindBy(xpath = "//a[@class='btn btn-default']")
    WebElement forgotPassword;

    public Login(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public void clickForgotPassword()
    {
        forgotPassword.click();
    }


    public void setTxtUsername(String username)
    {
        txtUsername.sendKeys(username);
    }

    public void setTxtPassword(String password)
    {
        txtPassword.sendKeys(password);
    }

    public void clickLogin() {
       btnLogin.click();
    }
}
