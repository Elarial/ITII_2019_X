package com.itii.planning.gui;

import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class mFichier extends JMenu {

	private static final long serialVersionUID = 1L;
	private static mFichier instance;

	public static mFichier getInstance() {
		if (instance == null) {
			instance = new mFichier();
		}
		return instance;
	}

	public void initialize() {
		this.setText("Fichier");
		this.add(new JMenuItem("Quitter"));
	}

	private mFichier() {
		initialize();
	}
}
