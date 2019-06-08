package com.itii.planning.gui;

import javax.swing.*;

/**
 * Menu déroulant Contenant la liste des vues.
 * @author Adrien
 */
public class DropDownMenu extends JComboBox {
    private enum comboBoxItem{
        Liste,Semaine,Mois
    }
    public DropDownMenu ()
    {
        super();
        this.setModel(new DefaultComboBoxModel<>(comboBoxItem.values()));
        ((JLabel)this.getRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }
}
