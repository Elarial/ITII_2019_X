package com.itii.planning;

import com.itii.planning.gui.MainWindow;
import com.itii.planning.dataBase.TaskPersistence;

import javax.swing.*;

/**
 * Point d'entrée de l'application.
 * @author Adrien
 */
public class Launcher {

        public static void main(String[] args)
        {
            //La chargement de l'application et de la base sql se font en parallèle dans deux taches.
            SwingUtilities.invokeLater(() -> MainWindow.getInstance());
            SwingUtilities.invokeLater(() -> TaskPersistence.createTable());

        }
}
