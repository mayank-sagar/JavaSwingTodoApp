package panels;

import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import constants.ButtonConstants;
import constants.LayoutConstants;
import controls.ControlManager;
import models.ControlData;
import validations.MaxLengthValidation;
import validations.RequiredValidation;
import validations.ValidationFields;
import validations.ValidationManager;

public class TodoFormPanel extends GridPanel {
	private static final long serialVersionUID = 1L;
	private JLabel title;
	private JLabel desc;
	private JTextField titleField;
	private JTextField desciptionField;
	private JButton addBtn;
	
	public TodoFormPanel() {
		ControlManager manager = ControlManager.getInstance();
		setSize(300,100);
		title = new JLabel("Name");
		desc = new JLabel("Desctiption");
		titleField =  new JTextField(10);
		titleField.setPreferredSize(new Dimension(100,30));
		desciptionField =  new JTextField(10);
		addBtn = new JButton(ButtonConstants.ADD_TODO_BTN);
		addBtn.setName(ButtonConstants.ADD_TODO_BTN_ID);
		addBtn.addActionListener(manager.getButtonActionListener());
		add(title,getGridBagDimensions(1,1,0,0, 0, GridBagConstraints.WEST));
		add(titleField,getGridBagDimensions(1,1,1,0, 0, GridBagConstraints.WEST));
		add(desc,getGridBagDimensions(1,1,0,1, 0, GridBagConstraints.WEST));
		add(desciptionField,getGridBagDimensions(1,1,1,1, 0, GridBagConstraints.WEST));
		add(addBtn,getGridBagDimensions(2,1,0,2, 0, GridBagConstraints.CENTER));
		ControlData controlData = manager.getControlData();
		controlData.titleTextField  = this.titleField;
		controlData.descTextField   = this.desciptionField;
		manager.addValidationFields(LayoutConstants.TODO_FORM_VALIDATION, createValidations());
	}
	
	
	private ValidationManager createValidations() {
		ValidationFields fieldTitle = new ValidationFields(titleField);
		ValidationFields fieldDec = new ValidationFields(desciptionField);
		fieldTitle.add(new RequiredValidation("Title"));
		fieldTitle.add(new MaxLengthValidation("Title",20));
		fieldDec.add(new RequiredValidation("Description"));
		fieldDec.add(new MaxLengthValidation("Description",80));
		ValidationManager manager = new ValidationManager();
		manager.addField(fieldTitle);
		manager.addField(fieldDec);
		return manager;
		
	}
}
