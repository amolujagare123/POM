package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import pages.Login;

import static util.ConfigReader.getPassword;
import static util.ConfigReader.getUsername;

public class DoLogin extends OpenUrl {

    @BeforeClass
    public void doLogin()
    {

        Login login = new Login(driver);
        /*login.setTxtUsername("amolujagare@gmail.com");
        login.setTxtPassword("admin123");*/
        login.setTxtUsername(getUsername());
        login.setTxtPassword(getPassword());
        login.clickLogin();
    }
}
