package com.itii.planning.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Class représentant le panel qui contient les autres composants.
 * @author Adrien
 */
public class PanelContainer extends JPanel {
    PanelContainer(Dimension windowDimension){
        super();
        this.setLayout(new BorderLayout());
        this.setPreferredSize(windowDimension);
    }
}
