package com.itii.planning.gui;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private static MainWindow instance;
    public static MainWindow getInstance()
    {
        if(instance == null)
            instance = new MainWindow();
        return instance;
    }
    private MainWindow(){
        super("JavaSwingApp");
        initialize();
    }
    private void initialize()
    {

        Dimension windowDimension = new Dimension(300,300);
        this.setSize(windowDimension);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*
        this.setLayout(new GridLayout(3,1));
        JLabel headerLabel = new JLabel("",JLabel.CENTER );
        JLabel statusLabel = new JLabel("",JLabel.CENTER);

         */

        this.validate();
        this.repaint();

        final MainMenuBar menuBar = new MainMenuBar();
        this.setJMenuBar(menuBar);

        this.setVisible(true);
    }
}
