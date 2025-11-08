package controls;

import models.ControlData;

public class ControlManager {
	private static ControlManager instance = null;
	private ButtonActionListeners listeners;
	private MenuActionListener menuListener;
	private ControlData controlData;
	private ControlManager() {
		controlData= new ControlData();
		listeners = new ButtonActionListeners(controlData);
		menuListener = new MenuActionListener(controlData);
	}
	
	
	public static ControlManager getInstance()	{
		if(ControlManager.instance == null) {
			ControlManager.instance = new ControlManager();
		}
		return ControlManager.instance;
	}
	
	public ButtonActionListeners getButtonActionListener() {
		return listeners;
	}
	
	public MenuActionListener getMenuActionListener() {
		return menuListener;
	}
	
	public ControlData getControlData() {
		return controlData;
	}
	
}
