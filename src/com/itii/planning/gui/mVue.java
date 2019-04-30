package com.itii.planning.gui;

import javax.swing.JMenu;

public class mVue extends JMenu {
	private static mVue instance;

	public static mVue getInstance() {
		if (instance == null) {
			instance = new mVue();
		}
		return instance;
	}

	public void initialize() {
		this.setText("Vue");
	}

	private mVue() {
		initialize();
	}

}
