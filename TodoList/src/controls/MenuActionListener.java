package controls;

import java.awt.event.ActionEvent;

import javax.swing.JMenuItem;

import constants.LayoutConstants;
import constants.MenuConstants;
import models.ControlData;

public class MenuActionListener extends MainActionListener {

	
	public MenuActionListener(ControlData cData) {
		super(cData);
}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = ((JMenuItem)e.getSource()).getName();
		if(name.equals(MenuConstants.MENU_ONE_MENU_ITEM_ONE_ID)) {
			cData.centerLayout.show(cData.centerPanel, LayoutConstants.TODO_FORM);
		}
		
		if(name.equals(MenuConstants.MENU_ONE_MENU_ITEM_TWO_ID)) {
			cData.centerLayout.show(cData.centerPanel, LayoutConstants.LIST_TODOS);
		}
	}

}
