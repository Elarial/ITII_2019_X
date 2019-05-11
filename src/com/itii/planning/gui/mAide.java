package com.itii.planning.gui;

import javax.swing.JMenu;

public class mAide extends JMenu {

	private static final long serialVersionUID = 1L;
	private static mAide instance;

	public static mAide getInstance() {
		if (instance == null) {
			instance = new mAide();
		}
		return instance;
	}

	public void initialize() {
		this.setText("Aide");
	}

	private mAide() {
		initialize();
	}

}
