package com.itii.planning.gui;

import javax.swing.JMenuBar;

public class MenuBar extends JMenuBar {

	private static final long serialVersionUID = 1L;
	private static MenuBar instance;

	public static MenuBar getInstance() {
		if (instance == null) {
			instance = new MenuBar();
		}
		return instance;
	}

	public void initialize() {
		mFichier menuFichier = mFichier.getInstance();
		mEdition menuEdition = mEdition.getInstance();
		mVue menuVue = mVue.getInstance();
		mAide menuAide = mAide.getInstance();
		this.add(menuFichier);
		this.add(menuEdition);
		this.add(menuVue);
		this.add(menuAide);

	}

	private MenuBar() {
		initialize();
	}

}
