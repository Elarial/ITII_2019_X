package com.itii.planning.gui;

import javax.swing.*;
//package private access
 class MainMenuBar extends JMenuBar {
     MainMenuBar()
    {
        super();
       createMenus();
       createMenuItems();

    }
    private void createMenus()
    {
        JMenu fileMenu = new JMenu("Fichier");
        JMenu editMenu = new JMenu("Edition");
        JMenu viewMenu = new JMenu("Vue");
        JMenu helpMenu = new JMenu("Aide");
        this.add(fileMenu);
        this.add(editMenu);
        this.add(viewMenu);
        this.add(helpMenu);
    }
    private void createMenuItems()
    {
        //TODO
    }
}
