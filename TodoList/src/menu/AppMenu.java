package menu;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class AppMenu extends JMenuBar {

	
	private static final long serialVersionUID = 1L;

	private AppMenu(ArrayList<JMenu> menus) {
		for(JMenu menu: menus) {
			add(menu);
		}
	}
	
	public static class AppMenuBuilder {
		
		private ArrayList<JMenu> menus;
		private HashMap<String,HashMap<String, JMenuItem>> mapMenus;
		
		public AppMenuBuilder() {
			menus = new ArrayList<JMenu>();
			mapMenus = new HashMap<String,HashMap<String, JMenuItem>>();
		}
		
		public AppMenuBuilder addMenu(String name, String menuId) {
			JMenu menu  = new JMenu(name);
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
