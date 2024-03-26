package apis.contactMessageSave;

import lombok.Data;

@Data
public class ResponseMessageSave {
    private ObjectMessageSave object;
    private String message;
    private String httpStatus;
}