package regression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.Login;
import util.OpenUrl;

import static util.ConfigReader.getPassword;
import static util.ConfigReader.getUsername;

public class LoginTest extends OpenUrl {

    @Test
    public void loginTest()
    {
        Login login = new Login(driver);
        login.setTxtUsername(getUsername());
        login.setTxtPassword(getPassword());
          login.clickLogin();
    }
}
