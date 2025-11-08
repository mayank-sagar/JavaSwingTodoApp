package panels;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Todo;
import models.TodoManager;

public class TodoListPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public TodoListPanel() {
		BoxLayout mainLayout  = new BoxLayout(this,BoxLayout.Y_AXIS);
		setLayout(mainLayout);
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
			add(row);
		}
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
}
