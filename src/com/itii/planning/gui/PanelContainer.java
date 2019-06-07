package com.itii.planning.gui;

import javax.swing.*;
import java.awt.*;

public class PanelContainer extends JPanel {
    PanelContainer(Dimension windowDimension){
        super();
        //this.setLayout(new GridBagLayout());
        this.setLayout(new BorderLayout());
        this.setPreferredSize(windowDimension);
       // System.out.println(windowDimension);
    }
}
