package com.itii.planning.gui;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class mVue extends JMenu {

	private static final long serialVersionUID = 1L;
	private static mVue instance;

	public static mVue getInstance() {
		if (instance == null) {
			instance = new mVue();
		}
		return instance;
	}

	public void initialize() {
		this.setText("Vue");
		this.add(new JMenuItem("Liste"));
		this.add(new JMenuItem("Semaine"));
		this.add(new JMenuItem("Mois"));
	}

	private mVue() {
		initialize();
	}

}
