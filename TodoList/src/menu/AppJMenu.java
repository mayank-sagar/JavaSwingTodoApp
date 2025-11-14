package menu;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JMenu;

public class AppJMenu extends JMenu {
	
	
	public AppJMenu(String name) {
		super(name);
	}
	@Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(196, 229, 56)); 
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
}
