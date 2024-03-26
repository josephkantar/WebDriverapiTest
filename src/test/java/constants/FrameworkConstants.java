package constants;


import utils.ConfigurationReaderFile;

public class FrameworkConstants {
    private FrameworkConstants() {
    }

    private final static String HOMEPAGE_URL = ConfigurationReaderFile.get("homePageUrl");
    private final static String REGISTER_URL = ConfigurationReaderFile.get("registerURL");
    private final static String GECERSIZ_EMAIL_LENGHT = "12345678901234567890123456789012345678901234567890123456789012345@gmail.com";
    private final static String BOS_DATA = "";
    private final static String FIRST_NAME = "Salih";
    private final static String LAST_NAME = "Gultekin";
    private final static String USER_NAME = "salih";
    private final static String PASSWORD = "Salihgltkn41.";
    private final static String VALIDEMAIL = ConfigurationReaderFile.get("validEmail");
    private final static String VALIDPASSWORD = ConfigurationReaderFile.get("validPassword");


    public static String getFirstName() {
        return FIRST_NAME;
    }

    public static String getHomepageUrl() {
        return HOMEPAGE_URL;
    }

    public static String getBosData() {
        return BOS_DATA;
    }

    public static String getLastName() {
        return LAST_NAME;
    }

    public static String getUserName() {
        return USER_NAME;
    }

    public static String getPassword() {
        return PASSWORD;
    }

    public static String getValidemail() {
        return VALIDEMAIL;
    }

    public static String getValidpassword() {
        return VALIDPASSWORD;
    }
}