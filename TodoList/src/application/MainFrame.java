package application;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import constants.MenuConstants;
import controls.ControlManager;
import menu.AppMenu;
import models.ControlData;

public class MainFrame extends JFrame {

	protected static final long serialVersionUID = 1L;
	protected CardLayout centerLayout;
	protected JPanel centerPanel;
	
	MainFrame(String name) {
		super(name);
		setSize(500,400);
	    BorderLayout layout = new BorderLayout();
	    layout.setHgap(10);
	    layout.setVgap(10);
		setLayout(layout);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon = new ImageIcon(getClass().getResource("/assets/icon.png"));
		setIconImage(icon.getImage());
		centerLayout = new CardLayout();
		centerPanel = new JPanel();
		centerPanel.setLayout(centerLayout);
		ControlManager manager = ControlManager.getInstance();
		ControlData controlData = manager.getControlData();
		controlData.centerLayout = centerLayout;
		controlData.centerPanel = centerPanel;
	}
	
	protected JMenuBar buildMainMenu() {
		return new AppMenu.AppMenuBuilder()
				.addMenu(MenuConstants.MENU_ONE_NAME, MenuConstants.MENU_ONE_ID)
				.addMenuItem(MenuConstants.MENU_ONE_ID,MenuConstants.MENU_ONE_MENU_ITEM_ONE, MenuConstants.MENU_ONE_MENU_ITEM_ONE_ID)
				.addMenuItemListeners(MenuConstants.MENU_ONE_ID,MenuConstants.MENU_ONE_MENU_ITEM_ONE_ID, 
				ControlManager.getInstance().getMenuActionListener())
				.addMenuItem(MenuConstants.MENU_ONE_ID,MenuConstants.MENU_ONE_MENU_ITEM_TWO, MenuConstants.MENU_ONE_MENU_ITEM_TWO_ID)
				.addMenuItemListeners(MenuConstants.MENU_ONE_ID,MenuConstants.MENU_ONE_MENU_ITEM_TWO_ID, 
				ControlManager.getInstance().getMenuActionListener())
				.build();
	}

}
