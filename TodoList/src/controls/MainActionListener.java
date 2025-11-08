package controls;

import java.awt.event.ActionListener;

import models.ControlData;

public abstract class MainActionListener implements ActionListener{

	protected ControlData cData;
	public MainActionListener(ControlData cData) {
			this.cData = cData;
	}
	
}
