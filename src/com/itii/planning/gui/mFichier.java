package com.itii.planning.gui;

import javax.swing.JMenu;

public class mFichier extends JMenu {

	private static mFichier instance;

	public static mFichier getInstance() {
		if (instance == null) {
			instance = new mFichier();
		}
		return instance;
	}

	public void initialize() {
		this.setText("Fichier");
	}

	private mFichier() {
		initialize();
	}
}
