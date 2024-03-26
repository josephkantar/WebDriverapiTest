package apis.contactMessageSave;

import lombok.Data;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
@Data
public class PayloadMessageSave  {

	private String name;
	private String email;
	private String subject;
	private String message;
}