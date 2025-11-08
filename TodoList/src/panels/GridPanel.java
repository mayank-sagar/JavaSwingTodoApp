package panels;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public abstract class GridPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	protected GridBagLayout layout;
	
	public GridPanel() {
		layout = new GridBagLayout();
		setLayout(layout);
	}
	protected GridBagConstraints getGridBagDimensions(int gridwidth,int gridheight,int gridx, int gridy, float weighty, int anchor) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = gridwidth;
		gbc.gridheight = gridheight;
		gbc.gridx = gridx;
		gbc.gridy = gridy;
		gbc.weighty = weighty;
		gbc.anchor = anchor;
		return gbc;
	}
}
