package controls;

import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import constants.ButtonConstants;
import constants.LayoutConstants;
import models.ControlData;
import models.Todo;
import models.TodoManager;
import validations.Valid;
import validations.ValidationManager;

public class ButtonActionListeners extends MainActionListener {

	TodoManager manager;
	ControlManager controlManager;
	public ButtonActionListeners(ControlData cData,ControlManager controlManager) {
			super(cData);
			manager = TodoManager.getInstance();
			this.controlManager = controlManager;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = ((JButton)e.getSource()).getName();
		JButton btn = ((JButton)e.getSource());
			
		
		if(name.equals(ButtonConstants.ACTION_ONE_ID)) {
			cData.centerLayout.show(cData.centerPanel, LayoutConstants.TODO_FORM);
		}
		
		
		if(name.equals(ButtonConstants.ACTION_TWO_ID)) {
			cData.centerLayout.show(cData.centerPanel, LayoutConstants.LIST_TODOS);
		}
		
		
		if(name.equals(ButtonConstants.ADD_TODO_BTN_ID)) {
			ValidationManager validations = controlManager.getValidateFields(LayoutConstants.TODO_FORM_VALIDATION);
			Valid valid  = validations.validate();
			System.out.println("Errororor:" + valid.message +": "+valid.isValid);
			if(!valid.isValid) {
				System.out.println("Errororor:" + valid.message);
				 JOptionPane.showMessageDialog(cData.centerPanel, valid.message,
			               "Swing Tester", JOptionPane.ERROR_MESSAGE);
				return;
			}
			manager.add(new Todo(cData.titleTextField.getText(),cData.descTextField.getText()));
			cData.titleTextField.setText("");
			cData.descTextField.setText("");
			cData.todoPanel.update();
			cData.centerLayout.show(cData.centerPanel, LayoutConstants.SUCCESS_ADDED);
		}
		
		
		if(name.equals(ButtonConstants.DELETE_BUTTON_ID)) {
			int id  = (Integer)btn.getClientProperty(ButtonConstants.TODO_ID_PROPERTY);
			TodoManager todos = TodoManager.getInstance();
			Todo todoItem = todos.getById(id);
			todos.remove(id);
			cData.todoPanel.remove(todoItem.getId());
		}
		
		if(name.equals(ButtonConstants.CREATE_NEW_BTN_ID)) {
			cData.centerLayout.show(cData.centerPanel, LayoutConstants.TODO_FORM);
		}
		
	}

}
