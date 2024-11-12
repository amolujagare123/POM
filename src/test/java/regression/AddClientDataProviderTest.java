package regression;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddClient;
import pages.Menu;
import util.DoLogin;

import java.io.IOException;

import static util.ForDataProvider.getMyData;

public class AddClientDataProviderTest extends DoLogin {

    @Test(dataProvider = "getData")
    public void addClientTest(
            String clientName, String clientSurname, String language, String streetAddress1,
            String streetAddress2, String city, String state, String zipCode, String country,
            String gender, String birthdate, String phoneNumber, String faxNumber,
            String mobileNumber, String emailAddress, String webAddress,
            String vatId, String taxesCode, String expected, String xpathActual, String message)
    {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);

        addClient.setClientName(clientName);
        addClient.setClientSurname(clientSurname);
        addClient.setLanguage(language);
        addClient.setStreetAddress1(streetAddress1);
        addClient.setStreetAddress2(streetAddress2);
        addClient.setCity(city);
        addClient.setState(state);
        addClient.setZipCode(zipCode);
        addClient.setCountry(country);
        addClient.setGender(gender);
        addClient.setBirthdate(birthdate);
        addClient.setPhoneNumber(phoneNumber);
        addClient.setFaxNumber(faxNumber);
        addClient.setMobileNumber(mobileNumber);
        addClient.setEmailAddress(emailAddress);
        addClient.setWebAddress(webAddress);
        addClient.setVATID(vatId);
        addClient.setTaxesCode(taxesCode);
        addClient.saveClient();

       // String expected = "PLEASE ENTER AT LEAST 3 CHARACTERS.";

        String actual = "";
        try {
            actual = driver.findElement(By.xpath(xpathActual)).getText();
        }
        catch (Exception e)
        {

        }
        System.out.println("actual="+actual);
        System.out.println("expected="+expected);

        Assert.assertEquals(actual,expected,message);

    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return getMyData("Data/client_data.xlsx","Sheet1");
    }
}
