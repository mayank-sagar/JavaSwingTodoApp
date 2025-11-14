package validations;

public class MaxLengthValidation implements Validate {
	String message = "<> should be max <char> characters.";
	int maxCharLength;
	
	public MaxLengthValidation(String fieldName, int maxCharLength) {
		message = message.replace( "<>",fieldName);
		message = message.replace("<char>",Integer.toString(maxCharLength));
		this.maxCharLength = maxCharLength;
	}
	
	@Override
	public Valid validate(String value) {
		if(value.length() > this.maxCharLength) return new Valid(false, message);
		return new Valid(true,"");
	}
}
