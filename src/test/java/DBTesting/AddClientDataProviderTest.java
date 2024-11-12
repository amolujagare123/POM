package DBTesting;

import com.mysql.cj.protocol.Resultset;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AddClient;
import pages.Menu;
import util.DoLogin;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;

import static util.Conversion.*;
import static util.ForDataProvider.getMyData;

public class AddClientDataProviderTest extends DoLogin {

    @Test(dataProvider = "getData")
    public void addClientTest(
            String clientName, String clientSurname, String language, String streetAddress1,
            String streetAddress2, String city, String state, String zipCode, String country,
            String gender, String birthdate, String phoneNumber, String faxNumber,
            String mobileNumber, String emailAddress, String webAddress,
            String vatId, String taxesCode) throws ClassNotFoundException, SQLException, ParseException {
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


        ArrayList<String> expected = new ArrayList<>();
        expected.add(clientName);
        expected.add(clientSurname);
        expected.add(language.toLowerCase());
        expected.add(streetAddress1);
        expected.add(streetAddress2);
        expected.add(city);
        expected.add(state);
        expected.add(zipCode);
        expected.add(country);
        expected.add(gender);
        expected.add(birthdate);
        expected.add(phoneNumber);
        expected.add(faxNumber);
        expected.add(mobileNumber);
        expected.add(emailAddress);
        expected.add(webAddress);
        expected.add(vatId);
        expected.add(taxesCode);

       // 1. loading a driver
        Class.forName("com.mysql.cj.jdbc.Driver");

      //  2. creating a connection
        String username = "root";
        String  password = "root"; // keep this blank if your mysql is from xampp
        String url = "jdbc:mysql://localhost:3306/ip";
        Connection con = DriverManager.getConnection(url,username,password);

      //  3. creating Statement
        Statement st = con.createStatement();
      //  4. Executing query
        String sql = "select * from ip_clients where client_name='"+clientName+"'";
        ResultSet rs = st.executeQuery(sql);

        ArrayList<String> actual = new ArrayList<>();

        while (rs.next()) {
            actual.add(rs.getString("client_name"));
            actual.add(rs.getString("client_surname"));
            actual.add(rs.getString("client_language"));
            actual.add(rs.getString("client_address_1"));
            actual.add(rs.getString("client_address_2"));
            actual.add(rs.getString("client_city"));
            actual.add(rs.getString("client_state"));
            actual.add(rs.getString("client_zip"));


            actual.add(convertCountry(rs.getString("client_country")));

            String dbGender = getGender(rs.getString("client_gender"));

            actual.add(dbGender);


            actual.add(convertDate(rs.getString("client_birthdate")));


            actual.add(rs.getString("client_phone"));
            actual.add(rs.getString("client_fax"));
            actual.add(rs.getString("client_mobile"));
            actual.add(rs.getString("client_email"));
            actual.add(rs.getString("client_web"));
            actual.add(rs.getString("client_vat_id"));
            actual.add(rs.getString("client_tax_code"));
        }

        System.out.println("expected="+expected);
        System.out.println("actual="+actual);

        Assert.assertEquals(actual,expected);

    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return getMyData("Data/client_data.xlsx","DBTesting");
    }
}
