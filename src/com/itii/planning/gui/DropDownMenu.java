package com.itii.planning.gui;

import javax.swing.JComboBox;

public class DropDownMenu extends JComboBox<String>{

	private static final long serialVersionUID = 1L;
	private static DropDownMenu instance;

	public static DropDownMenu getInstance() {
		if (instance == null) {
			instance = new DropDownMenu();
		}
		return instance;
	}
	public void initialize() {
		this.addItem("Liste");
		this.addItem("Semaine");
		this.addItem("Mois");
		this.addActionListener(this);

	}

	private DropDownMenu() {
		initialize();
	}

}
