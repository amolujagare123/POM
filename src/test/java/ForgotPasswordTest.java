import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ForgotPasswordTest {

    @Test
    public void forgotPasswordTest()
    {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://[::1]/ip");

        Login login = new Login(driver);
        login.clickForgotPassword();

        ForgotPassword forgotPassword = new ForgotPassword(driver);
        forgotPassword.setTxtEmail("amol@gmail.com");
        forgotPassword.clickRest();

    }
}
