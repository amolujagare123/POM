import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void loginTest()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://[::1]/ip");

        Login login = new Login(driver);
        login.setTxtUsername("amolujagare@gmail.com");
        login.setTxtPassword("admin123");
        login.clickLogin();
    }
}
