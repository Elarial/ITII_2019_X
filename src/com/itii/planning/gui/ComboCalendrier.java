/**
 * 
 */
package com.itii.planning.gui;

import javax.swing.JComboBox;

/**
 * @author user
 *
 */
public class ComboCalendrier extends JComboBox<String>
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private static ComboCalendrier INSTANCE;
  
  public static ComboCalendrier getInstance() {
    if(INSTANCE == null) {
      INSTANCE = new ComboCalendrier();
    }
      return INSTANCE;
  }
  private void initialize()
  {
    this.addItem("Liste");
    this.addItem("Semaine");
    this.addItem("Mois");
    this.addActionListener(this);
  }
  
  private ComboCalendrier()
  {
   initialize(); 
  }
}
