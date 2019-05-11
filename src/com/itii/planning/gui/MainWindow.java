package com.itii.planning.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class MainWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	private static MainWindow instance;

	public static MainWindow getInstance() {
		if (instance == null) {
			instance = new MainWindow();
		}
		return instance;
	}

	public void initialize() {
		setSize(780, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.validate();
		this.repaint();
		this.setJMenuBar(MenuBar.getInstance());
		setLayout(new BorderLayout(5, 5));
		this.getContentPane().add(DropDownMenu.getInstance(), BorderLayout.NORTH);
		this.pack();
	}

	private MainWindow() {
		initialize();
	}

}
