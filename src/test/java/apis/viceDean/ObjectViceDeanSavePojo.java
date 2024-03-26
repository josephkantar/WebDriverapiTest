package apis.viceDean;

import lombok.Data;

@Data
public class ObjectViceDeanSavePojo {
    private int userId;
    private String username;
    private String name;
    private String surname;
    private String birthDay;
    private String ssn;
    private String birthPlace;
    private String phoneNumber;
    private String gender;
}