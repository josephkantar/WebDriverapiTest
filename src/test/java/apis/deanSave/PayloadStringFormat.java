package apis.deanSave;

public class PayloadStringFormat {

    //Pojo class oluşturmadan expected datayı bu şekilde oluşturabiliriz. Fakat bu projede kullanmadık bilgi amaçlı buraya koyduk.
    public static String PayloadDeanSave
    (
            String name,
            String surname,
            String gender,
            String birthDay,
            String phoneNumber,
            String ssn,
            String username,
            String password,
            String birthPlace
    ) {
        return "{\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"surname\": \"" + surname + "\",\n" +
                "  \"gender\": \"" + gender + "\",\n" +
                "  \"birthDay\": \"" + birthDay + "\",\n" +
                "  \"phoneNumber\": \"" + phoneNumber + "\",\n" +
                "  \"ssn\": \"" + ssn + "\",\n" +
                "  \"username\": \"" + username + "\",\n" +
                "  \"password\": \"" + password+ "\",\n" +
                "  \"birthPlace\": \"" + birthPlace + "\"\n" +

            "}";
    }
}