package regression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddClient;
import pages.Login;
import pages.Menu;
import util.DoLogin;

public class AddClientTest extends DoLogin {

    @Test
    public void addClientTest()
    {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);


        addClient.setClientName("John");
        addClient.setClientSurname("Doe");
        addClient.setLanguage("Spanish");
        addClient.setStreetAddress1("123 Main St");
        addClient.setStreetAddress2("Apt 4B");
        addClient.setCity("Metropolis");
        addClient.setState("NY");
        addClient.setZipCode("12345");
        addClient.setCountry("Libya");
        addClient.setGender("Female");
        addClient.setBirthdate("05/09/1985");
        addClient.setPhoneNumber("5551234567");
        addClient.setFaxNumber("5559876543");
        addClient.setMobileNumber("5551230987");
        addClient.setEmailAddress("john.doe@example.com");
        addClient.setWebAddress("http://johndoe.com");
        addClient.setVATID("VAT123456");
        addClient.setTaxesCode("TAX78910");
        addClient.saveClient();
    }
}
