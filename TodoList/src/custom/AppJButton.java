package custom;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class AppJButton extends JButton {

	
	public AppJButton() {
		super();
		initButtonStyles();
	}
	
	public AppJButton(String name) {
		super(name);
		initButtonStyles();
	}
	
	private void initButtonStyles() {
		this.setMargin(new Insets(5,10,5,10));
			this.setForeground(new Color(25, 42, 86));
			setFont(new Font("Arial", Font.BOLD, 16));  


	}
}
