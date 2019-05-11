package com.itii.planning.gui;

import javax.swing.*;
import java.awt.*;



public class RightPanel extends JPanel {
    RightPanel(){
        super();
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;


        JButton createButton = new JButton("Créer");

        //createButton.setAlignmentX(Component.RIGHT_ALIGNMENT);
        c.gridy = 0;
        this.add(new JButton("Créer"),c);
        //this.add(createButton);
        c.gridy = 1;
        this.add(new JButton("Editer"),c);
        c.gridy = 2;
        this.add(new JButton("Marquer"),c);
        c.gridy = 3;
        this.add(new JButton("Dupliquer"),c);
        c.gridy = 4;
        this.add(new JButton("Supprimer"),c);
    }
}
