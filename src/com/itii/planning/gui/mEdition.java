package com.itii.planning.gui;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class mEdition extends JMenu{

	private static final long serialVersionUID = 1L;
	private static mEdition instance;

	public static mEdition getInstance() {
		if (instance == null) {
			instance = new mEdition();
		}
		return instance;
	}

	public void initialize() {
		this.setText("Edition");
		this.add(new JMenuItem("Créer"));
		this.add(new JMenuItem("Editer"));
		this.add(new JMenuItem("Marquer"));
		this.add(new JMenuItem("Dupliquer"));
		this.add(new JMenuItem("Supprimer"));
	}

	private mEdition() {
		initialize();
	}

}
