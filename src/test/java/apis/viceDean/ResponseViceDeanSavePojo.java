package apis.viceDean;

import apis.deanSave.ObjectDeanSavePojo;
import lombok.Data;


@Data
public class ResponseViceDeanSavePojo {
    private ObjectDeanSavePojo object;
    private String message;
    private String httpStatus;
}