package validations;

import java.util.ArrayList;

public class ValidationManager {

	private ArrayList<ValidationFields> fields; 

	public ValidationManager() {
		fields = new ArrayList<ValidationFields>();
	}
	
	public void addField(ValidationFields field) {
		fields.add(field);
	}
	
	public Valid validate() {
		Valid valid  = new Valid(true,"");
		for(ValidationFields field: fields) {
			valid = field.validate();
			if(!valid.isValid) {
				break;
			}
		}
		return valid;
	}
	
}
