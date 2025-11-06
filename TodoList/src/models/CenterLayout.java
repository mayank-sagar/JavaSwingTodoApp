package models;

import javax.swing.JPanel;

public class CenterLayout {

	private String name;
	private JPanel panel;
	
	public CenterLayout(String name, JPanel panel) {
		this.name = name;
		this.panel = panel;
	}
	
	
	public String getName() {
		
		return name;
	}
	
	
	public JPanel getPanel() {
		return panel;
	}
	
	
}
