package apis.deanSave;

import lombok.Data;


@Data
public class ResponseDeanSavePojo {
    private ObjectDeanSavePojo object;
    private String message;
    private String httpStatus;
}