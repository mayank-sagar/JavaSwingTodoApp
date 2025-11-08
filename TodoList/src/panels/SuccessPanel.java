package panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JLabel;

import constants.ButtonConstants;
import controls.ControlManager;

public class SuccessPanel extends GridPanel {

	private static final long serialVersionUID = 1L;
	private JLabel messageLabel;
	private JButton actionButtonOne;
	private JButton actionButtonTwo;
	
	public SuccessPanel(String message, String actionOne, String actionTwo) {
		ControlManager manager = ControlManager.getInstance();
		this.messageLabel = new JLabel(message);
		messageLabel.setFont(new Font("Arial", Font.BOLD, 18));
		messageLabel.setForeground(new Color(0,128,0));
		this.actionButtonOne = new JButton(actionOne);
		actionButtonOne.setName(ButtonConstants.ACTION_ONE_ID);
		actionButtonOne.addActionListener(manager.getButtonActionListener());
		this.actionButtonTwo = new JButton(actionTwo);
		actionButtonTwo.setName(ButtonConstants.ACTION_TWO_ID);
		actionButtonTwo.addActionListener(manager.getButtonActionListener());
		add(messageLabel,getGridBagDimensions(2,1,0,0,0.1f,GridBagConstraints.EAST));
		add(actionButtonOne,getGridBagDimensions(1,1,0,1,0,GridBagConstraints.EAST));
		add(actionButtonTwo,getGridBagDimensions(1,1,1,1,0,GridBagConstraints.EAST));
	}
	
	
 
}
