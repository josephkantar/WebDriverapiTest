package apis.viceDean;


import lombok.Data;

@Data
public class PayloadViceDeanSavePojo {
    private String name;
    private String surname;
    private String gender;
    private String birthDay;
    private String birthPlace;
    private String phoneNumber;
    private String ssn;
    private String username;
    private String password;
}