package com.itii.planning.gui;

import javax.swing.*;
//package private access
 class MainMenuBar extends JMenuBar {



     MainMenuBar()
    {
        super();
       createMenus();

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
        fileMenu.add(new JMenuItem("Quitter"));
        editMenu.add(new JMenuItem("Créer"));
        editMenu.add( new JMenuItem("Editer"));
        editMenu.add( new JMenuItem("Marquer"));
        editMenu.add( new JMenuItem("Dupliquer"));
        editMenu.add( new JMenuItem("Supprimer"));
        viewMenu.add(new JMenuItem("Liste"));
        viewMenu.add(new JMenuItem("Semaine"));
        viewMenu.add(new JMenuItem("Mois"));

    }

}
