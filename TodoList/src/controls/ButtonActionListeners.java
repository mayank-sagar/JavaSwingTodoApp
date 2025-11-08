package controls;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import constants.ButtonConstants;
import constants.LayoutConstants;
import models.ControlData;

public class ButtonActionListeners extends MainActionListener {

	public ButtonActionListeners(ControlData cData) {
			super(cData);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = ((JButton)e.getSource()).getName();
		if(name.equals(ButtonConstants.ADD_TODO_BTN_ID)) {
			cData.centerLayout.show(cData.centerPanel, LayoutConstants.SUCCESS_ADDED);
		}	
		
		if(name.equals(ButtonConstants.ACTION_ONE_ID)) {
			cData.centerLayout.show(cData.centerPanel, LayoutConstants.TODO_FORM);
		}
		
		
		if(name.equals(ButtonConstants.ACTION_TWO_ID)) {
			cData.centerLayout.show(cData.centerPanel, LayoutConstants.LIST_TODOS);
		}
		
	}

}
