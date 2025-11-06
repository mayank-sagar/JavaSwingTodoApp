package application;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import constants.LayoutConstants;
import models.CenterLayout;
import models.Todo;
import models.TodoManager;

public class TodoApplication extends JFrame{
	
	private CardLayout centerLayout;
	private JPanel centerPanel;

	private TodoApplication() {
		super("Todo's");
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
	}
	
	public static void launch() {
		TodoApplication todo = new TodoApplication();
		todo.run();
		
	}
	
	
	private JMenuBar buildMenu() {
		JMenuBar menu  = new JMenuBar();
		
		// Creating Menu's
		JMenu actions = new JMenu("Actions");
		JMenuItem addTodoItem  = new JMenuItem("Add Todo");
		JMenuItem addListItem  = new JMenuItem("List Todo");
		actions.add(addTodoItem);
		actions.add(addListItem);
		menu.add(actions);
		
		return menu;
	}
	
	
	
	
	private JPanel buildTodoForm() {
		JPanel form = new JPanel();
		form.setSize(300,100);
		form.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		JLabel title = new JLabel("Name");
		JLabel desc = new JLabel("Desctiption");
		JTextField titleField =  new JTextField(10);
		titleField.setPreferredSize(new Dimension(100,30));
		JTextField desciptionField =  new JTextField(10);
		JButton addBtn = new JButton("Add Todo");
		addBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				centerLayout.show(centerPanel, LayoutConstants.SUCCESS_ADDED);
			}
			
		});
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		form.add(title,gbc);
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 0;
		form.add(titleField,gbc);
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		form.add(desc,gbc);
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 1;
		form.add(desciptionField,gbc);
		gbc.gridheight=1;
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		form.add(addBtn,gbc);
		return form;
	}
	
	
	private JPanel buildCenter(JMenuBar menu, CenterLayout... layouts) {
		JPanel successPanel  = this.buildSuccessPanel("Successfully Item added","Back","Go to listing",
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						centerLayout.show(centerPanel, LayoutConstants.TODO_FORM);
						
					}
			
		},new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				centerLayout.show(centerPanel, LayoutConstants.LIST_TODOS);
			}
	
		});
		for(CenterLayout cl : layouts) {
			centerPanel.add(cl.getPanel(),cl.getName());
		}
		centerPanel.add(successPanel,LayoutConstants.SUCCESS_ADDED);
		centerLayout.show(centerPanel, layouts[0].getName());
		JMenuItem addTodoItem = menu.getMenu(0).getItem(0);
		JMenuItem addListItem = menu.getMenu(0).getItem(1);
		addTodoItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				centerLayout.show(centerPanel, LayoutConstants.TODO_FORM);
			}
			
		});
		addListItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				centerLayout.show(centerPanel, LayoutConstants.LIST_TODOS);
			}
			
		});
		return centerPanel;
	}
	
	
	private JPanel buildTodoListing() {
		JPanel centerPanel = new JPanel();
		BoxLayout mainLayout  = new BoxLayout(centerPanel,BoxLayout.Y_AXIS);
//		mainLayout
		centerPanel.setLayout(mainLayout);
		TodoManager todos = TodoManager.getInstance();
		todos.add(new Todo("Item 1","This is test description"));
		todos.add(new Todo("Item 2","This is test description"));
		todos.add(new Todo("Item 3","This is test description"));
		todos.add(new Todo("Item 4","This is test description"));
		todos.add(new Todo("Item 5","This is test description"));
		todos.add(new Todo("Item 6","This is test description"));
		int length = todos.length();
		for(int i = 0; i < length;i++) {
			JPanel row = buildTodoItem(todos.get(i));
			row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 28));
			centerPanel.add(row);
		}
		return centerPanel;
	}
	
	private JPanel buildTodoItem(Todo todo) {
		JPanel panel = new JPanel();
		JLabel title = new JLabel(todo.getName());
		JCheckBox completed = new JCheckBox("",todo.isCompleted());
		JButton remove = new JButton("X");
		remove.setPreferredSize(new Dimension(20, 20));
		panel.add(title);
		panel.add(completed);
		panel.add(remove);
		return panel;
	}
	
	
	private JPanel buildSuccessPanel(String message,String actionOne,String actionTwo,
			ActionListener actionListenerOne,ActionListener actionListenerTwo) {
		JPanel panel = new JPanel();
		GridBagLayout gridBagLayout = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		panel.setLayout(gridBagLayout);
		JLabel messageLabel = new JLabel(message);
		messageLabel.setFont(new Font("Arial", Font.BOLD, 18));
		messageLabel.setForeground(new Color(0,128,0));
		JButton actionButtonOne = new JButton(actionOne);
		actionButtonOne.setName("actionOne");
		actionButtonOne.addActionListener(actionListenerOne);
		JButton actionButtonTwo = new JButton(actionTwo);
		actionButtonTwo.setName("actionTwo");
		actionButtonTwo.addActionListener(actionListenerTwo);
		gbc.gridheight = 1;
		gbc.gridwidth = 2;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 0.1;
		panel.add(messageLabel,gbc);
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weighty = 0;
		panel.add(actionButtonOne,gbc);
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(actionButtonTwo,gbc);
		return panel;
		
	}
	
	
	private void  run() {
		
		JPanel form = this.buildTodoForm();
		JPanel todoListing = this.buildTodoListing();
		JMenuBar menu = this.buildMenu();
		JPanel center = this.buildCenter(
			menu,
			new CenterLayout(LayoutConstants.TODO_FORM,form),
			new CenterLayout(LayoutConstants.LIST_TODOS,todoListing)
		);
		this.add(menu,BorderLayout.NORTH);
		this.add(center,BorderLayout.CENTER);
		super.setVisible(true);

	}
}
