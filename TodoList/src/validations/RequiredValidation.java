package validations;

public class RequiredValidation implements Validate {

	String message = "<> is required";
	
	public RequiredValidation(String fieldName) {
		message = message.replace("<>",fieldName);
	}
	
	@Override
	public Valid validate(String value) {
		if(value.trim().equals("")) return new Valid(false, message);
		return new Valid(true,"");
	}

}
