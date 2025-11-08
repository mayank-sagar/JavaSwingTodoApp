package application;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import constants.LayoutConstants;
import constants.MenuConstants;
import controls.ControlManager;
import menu.AppMenu;
import models.CenterLayout;
import models.ControlData;
import panels.SuccessPanel;
import panels.TodoFormPanel;
import panels.TodoListPanel;

public class TodoApplication extends MainFrame {
	

	private static final long serialVersionUID = 1L;


	private TodoApplication() {
		super("Todo's");
	}
	
	public static void launch() {
		TodoApplication todo = new TodoApplication();
		todo.run();
		
	}
	
	
	private JPanel buildTodoForm() {
		TodoFormPanel todoFormPanel = new TodoFormPanel();
		return todoFormPanel;
	}
	
	
	private JPanel buildCenter(CenterLayout... layouts) {
		for(CenterLayout cl : layouts) {
			centerPanel.add(cl.getPanel(),cl.getName());
		}
		centerLayout.show(centerPanel, layouts[0].getName());
		return centerPanel;
	}
	
	
	private JPanel buildTodoListing() {
		return new TodoListPanel();
	}
	
	
	private JPanel buildSuccessPanel(String message,String actionOne,String actionTwo) {
		return new SuccessPanel(message,actionOne,actionTwo);
	}
	
	
	private void  run() {
		
		JPanel form = this.buildTodoForm();
		JPanel todoListing = this.buildTodoListing();
		JMenuBar menu = this.buildMainMenu();
		JPanel successPanel  = this.buildSuccessPanel(LayoutConstants.SUCCESS_PANEL_SUCCESS_MESSAGE,
													  LayoutConstants.SUCCESS_PANEL_BACK,
													  LayoutConstants.SUCCESS_PANEL_BACK_TO_LISTSING);
		JPanel center = this.buildCenter(
			new CenterLayout(LayoutConstants.TODO_FORM,form),
			new CenterLayout(LayoutConstants.LIST_TODOS,todoListing),
			new CenterLayout(LayoutConstants.SUCCESS_ADDED,successPanel)
		);
		this.add(menu,BorderLayout.NORTH);
		this.add(center,BorderLayout.CENTER);
		super.setVisible(true);

	}
}
