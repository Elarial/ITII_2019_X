/**
 * 
 */
package com.itii.planning.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

/**
 * @author user
 *
 */
public class MainPanel extends JPanel
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private static MainPanel INSTANCE;
  
  public static MainPanel getInstance() {
    if(INSTANCE == null) {
      INSTANCE = new MainPanel();
    }
    return INSTANCE;
  }
  
  public void initialize()
  {
    JPanel mainPanel            = new JPanel();
    JPanel panelChoixCalendrier = new JPanel();
    
    mainPanel.setBackground(Color.blue);
    panelChoixCalendrier.setBackground(Color.red);
    panelChoixCalendrier.add(ComboCalendrier.getInstance());
    
    setLayout(new BorderLayout());
    add(panelChoixCalendrier, BorderLayout.NORTH);
    this.add(mainPanel, BorderLayout.CENTER);
    
    
  }
  
  private MainPanel() {
    initialize();
  }
}
