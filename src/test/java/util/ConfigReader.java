package util;

import java.util.ResourceBundle;

public class ConfigReader {

    public static  String getUrl()
    {
        return ResourceBundle.getBundle("config").getString("url");
    }

    public static  String getUsername()
    {
        return ResourceBundle.getBundle("config").getString("username");
    }

    public static  String getPassword()
    {
        return ResourceBundle.getBundle("config").getString("password");
    }
}
