package menu;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class AppMenu extends JMenuBar {

	
	private static final long serialVersionUID = 1L;

	private AppMenu(ArrayList<AppJMenu> menus) {
		for(JMenu menu: menus) {
			menu.setOpaque(true);
//			menu.setBackground(Color.TRANSLUCENT);
//			menu.setUI(null);
			menu.setBackground(new Color(196, 229, 56));
			menu.setForeground(Color.BLACK);
			add(menu);
		}
		setOpaque(true);
		setBackground(new Color(196, 229, 56));
		setBorder(BorderFactory.createEmptyBorder());
	}
	
	   public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        g.setColor(new Color(196, 229, 56));
	        g.fillRect(0, 0, getWidth(), getHeight());
	    }
	
	public static class AppMenuBuilder {
		
		private ArrayList<AppJMenu> menus;
		private HashMap<String,HashMap<String, JMenuItem>> mapMenus;
		
		public AppMenuBuilder() {
			menus = new ArrayList<AppJMenu>();
			mapMenus = new HashMap<String,HashMap<String, JMenuItem>>();
		}
		
		public AppMenuBuilder addMenu(String name, String menuId) {
			AppJMenu menu  = new AppJMenu(name);
			menu.setName(menuId);
			menus.add(menu);
			mapMenus.put(menuId,new HashMap<String, JMenuItem>());
			return this;
		}
		
		public AppMenuBuilder addMenuItem(String menuId,String menuItemName, String menuItemNameId) {
			if(mapMenus.containsKey(menuId)) {
				JMenuItem mItem = new JMenuItem(menuItemName);
				mItem.setName(menuItemNameId);
				HashMap<String, JMenuItem> items = mapMenus.get(menuId);
				items.put(menuItemNameId, mItem);
			}
			return this;
		}
		
		public AppMenuBuilder addMenuItemListeners(String menuId, String menuItemNameId, ActionListener menuItemListener) {
			if(mapMenus.containsKey(menuId)) {
				HashMap<String, JMenuItem> menuItems = mapMenus.get(menuId);
				if(menuItems.containsKey(menuItemNameId)) {
					JMenuItem item = menuItems.get(menuItemNameId);
					item.addActionListener(menuItemListener);
					System.out.println(item.getName());
				}
			}
			return this;
		}
		
		public AppMenu build() {
			for(JMenu menu : menus) {
				String menuId  = menu.getName();
				if(mapMenus.containsKey(menuId)) {
					HashMap<String, JMenuItem> items = mapMenus.get(menuId);
					for(JMenuItem menuItem : items.values()) {
						menu.add(menuItem);
					}
				}
			}
			return new AppMenu(menus);
		}

		
	}
}
