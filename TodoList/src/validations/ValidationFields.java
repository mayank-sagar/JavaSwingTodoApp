package validations;

import java.util.ArrayList;
import java.util.function.Consumer;

import javax.swing.JTextField;

public class ValidationFields {
	private ArrayList<Validate> validationFields;
	private JTextField field;
	
	public ValidationFields(JTextField field) {
		this.validationFields  = new ArrayList<Validate>();
		this.field = field;
	}
	
	
	public void add(Validate validate) {
		validationFields.add(validate);
	}
	
	public Valid validate() {
		Valid valid  = new Valid(true,"");
		
		
		for(Validate field: validationFields) {
			valid = field.validate(this.field.getText());
			if(!valid.isValid) {
				break;
			}
		}
		return valid;
	}
}
