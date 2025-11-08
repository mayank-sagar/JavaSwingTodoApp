package panels;

import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import constants.ButtonConstants;
import controls.ControlManager;

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
	}
}
