package com.itii.planning.gui;

import javax.swing.JMenu;

public class mEdition extends JMenu{
	private static mEdition instance;

	public static mEdition getInstance() {
		if (instance == null) {
			instance = new mEdition();
		}
		return instance;
	}

	public void initialize() {
		this.setText("Edition");
	}

	private mEdition() {
		initialize();
	}

}
