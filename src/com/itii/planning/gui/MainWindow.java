package com.itii.planning.gui;

import javax.swing.JFrame;

public class MainWindow extends JFrame {
	private static MainWindow instance;
	
	public static MainWindow getInstance() {
		if(instance==null) {
			instance = new MainWindow();
		}
		return instance;
	}
	public void initialize()
	{
		setSize(780, 600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.validate();
		this.repaint();
	}
	private MainWindow() {
		initialize();
	}

}
