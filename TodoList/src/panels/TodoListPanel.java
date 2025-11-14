package panels;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import constants.ButtonConstants;
import constants.LayoutConstants;
import controls.ControlManager;
import custom.AppJButton;
import interfaces.CotrollableControl;
import models.ControlData;
import models.Todo;
import models.TodoManager;

public class TodoListPanel extends JPanel implements CotrollableControl {

	private static final long serialVersionUID = 1L;
	private ControlManager manager;
	private HashMap<Integer,JPanel> rows;
	private JPanel todoPanel;
	private CardLayout mainLayout;
	
	public TodoListPanel() {
		mainLayout = new CardLayout();
		setLayout(mainLayout);
		manager = ControlManager.getInstance();
		ControlData controlData  = manager.getControlData();
		controlData.todoPanel  = this;
		initilizeEmptyLayoutIfEmpty();
		initilizeTodoPanel();
		TodoManager todos = TodoManager.getInstance();
		if(todos.length() <=0 ) {
			mainLayout.show(this, LayoutConstants.TODO_EMPTY_ITEMS_PANEL);
		} else {
			mainLayout.show(this, LayoutConstants.TODO_ITEMS_PANEL);
		}
		this.setBackground(new Color(163, 203, 56));
	}

	
	
	private void initilizeEmptyLayoutIfEmpty() {
			JPanel emptyPanel = emptyPanel();
			emptyPanel.setBackground(new Color(163, 203, 56));
			add(emptyPanel, LayoutConstants.TODO_EMPTY_ITEMS_PANEL);
	}
	
	
	private void initilizeTodoPanel() {
			todoPanel = new JPanel();
			todoPanel.setBackground(new Color(163, 203, 56));
			BoxLayout todoLayout  = new BoxLayout(todoPanel,BoxLayout.Y_AXIS);
			todoPanel.setLayout(todoLayout);
			add(todoPanel, LayoutConstants.TODO_ITEMS_PANEL);
			rows = new HashMap<Integer,JPanel>();
			
	}
	
	
	
	private JPanel emptyPanel() {
		JPanel panel  = new JPanel();
		GridBagLayout emptyInnerLayout  = new GridBagLayout();
		panel.setLayout(emptyInnerLayout);
		GridBagConstraints gbc = new GridBagConstraints();
		JLabel message = new JLabel("Hurray, No todo's available.");
		JButton button = new AppJButton(ButtonConstants.CREATE_NEW_BTN);
		button.setName(ButtonConstants.CREATE_NEW_BTN_ID);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		panel.add(message,gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		panel.add(button,gbc);
		button.addActionListener(manager.getButtonActionListener());
		return panel;
	}
	
	private JPanel buildTodoItem(Todo todo) {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(163, 203, 56));
		JLabel title = new JLabel(todo.getName());
		JCheckBox completed = new JCheckBox("",todo.isCompleted());
		JButton remove = new JButton(ButtonConstants.DELETE_BUTTON);
		remove.setName(ButtonConstants.DELETE_BUTTON_ID);
		remove.putClientProperty(ButtonConstants.TODO_ID_PROPERTY,todo.getId());
		remove.addActionListener(manager.getButtonActionListener());
		panel.add(title);
		panel.add(completed);
		panel.add(remove);
		return panel;
	}


	@Override
	public void update() {
		updateList();
	}
	
	public void remove(int id) {
		JPanel panel = rows.get(id);
		panel.setVisible(false);
		updateList();
	}
	
	
	private void updateList() {
			TodoManager todos = TodoManager.getInstance();
			todoPanel.removeAll();
			rows.clear();
			int length = todos.length();
			System.out.println("Size: "+length);
			for(int i = 0; i < length; i++) {
				JPanel row = buildTodoItem(todos.get(i));
				row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 28));
				todoPanel.add(row);
				row.setName(""+i+"");
				rows.put(todos.get(i).getId(), row);
			}
			todoPanel.repaint();
			
			if(todos.length() <= 0) {
				mainLayout.show(this, LayoutConstants.TODO_EMPTY_ITEMS_PANEL);
			} else {
				mainLayout.show(this, LayoutConstants.TODO_ITEMS_PANEL);
			}
//			repaint();
	}
}
