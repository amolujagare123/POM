package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversion {

    public static String getGender(String genderID) // 0 / 1 /  2
    {
        String gender="";

        switch (genderID)
        {
            case "0" : gender = "Male";break;
            case "1" : gender = "Female";break;
            case "2" : gender = "Other";break;
        }

        return gender;

    }

    public static String convertCountry(String shortCountry) // 0 / 1 /  2
    {
        String convertedCountry="";

        switch (shortCountry)
        {
            case "IN": convertedCountry = "India"; break;
            case "US": convertedCountry = "United States"; break;
            case "CA": convertedCountry = "Canada"; break;
            case "GB": convertedCountry = "United Kingdom"; break;
            case "AU": convertedCountry = "Australia"; break;
            case "FR": convertedCountry = "France"; break;
            case "DE": convertedCountry = "Germany"; break;
            case "JP": convertedCountry = "Japan"; break;
            case "CN": convertedCountry = "China"; break;
            case "BR": convertedCountry = "Brazil"; break;
            case "IT": convertedCountry = "Italy"; break;
            case "ES": convertedCountry = "Spain"; break;
            case "MX": convertedCountry = "Mexico"; break;
            case "RU": convertedCountry = "Russia"; break;
            case "ZA": convertedCountry = "South Africa"; break;
            case "KR": convertedCountry = "South Korea"; break;  }

        return convertedCountry;
    }
    /*      Expected :01/10/1987 - dd/MM/yyyy - Excel
            Actual   :1987-10-01 - yyyy-MM-dd - DB      */

    public static String convertDate(String dbDateStr) throws ParseException {
        // 1. convert db Date (String) into Date format
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dbDateStr);

        // 2. convert Date into String
        return new SimpleDateFormat("dd/MM/yyyy").format(date);
    }
}
