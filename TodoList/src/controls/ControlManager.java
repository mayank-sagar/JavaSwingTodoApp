package controls;

import java.util.HashMap;

import models.ControlData;
import validations.ValidationManager;

public class ControlManager {
	private static ControlManager instance = null;
	private ButtonActionListeners listeners;
	private MenuActionListener menuListener;
	private ControlData controlData;
	private HashMap<String,ValidationManager> validationManagers;
	
	private ControlManager() {
		controlData= new ControlData();
		listeners = new ButtonActionListeners(controlData,this);
		menuListener = new MenuActionListener(controlData);
		validationManagers = new HashMap<String,ValidationManager> ();
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
	
	public void addValidationFields(String name, ValidationManager validations) {
		validationManagers.put(name, validations);
	}
	
	public ValidationManager getValidateFields(String name) {
		return validationManagers.get(name);
	}
	
}
