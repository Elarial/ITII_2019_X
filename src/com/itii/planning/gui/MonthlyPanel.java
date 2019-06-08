package com.itii.planning.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Class représentant la vue mensuelle.
 * @author Adrien
 */
public class MonthlyPanel extends JPanel {
    MonthlyPanel(){
        super();
        this.add(new JButton("Monthly"));
        this.setBackground(Color.GREEN);
    }
}
