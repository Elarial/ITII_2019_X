/**
 * 
 */
package com.itii.planning.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
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
  
  private void initialize()
  {
    JPanel mainPanel            = new JPanel();
    JPanel panelChoixCalendrier = new JPanel();
    JPanel panelOptionTaches    = new JPanel();
    

    
    mainPanel.setBackground(Color.blue);
    panelChoixCalendrier.setBackground(Color.red);
    panelOptionTaches.setBackground(Color.pink);
    
    panelChoixCalendrier.add(ComboCalendrier.getInstance());
    
    
    
    setLayout(new BorderLayout());
    this.add(panelChoixCalendrier, BorderLayout.NORTH);
    this.add(panelOptionTaches,BorderLayout.EAST);
    this.add(mainPanel, BorderLayout.CENTER);
    
    panelOptionTaches.setLayout(new GridBagLayout());
    panelOptionTaches.add(ListeButtonTasks.getInstance());
    
    
    
  }
  
  private MainPanel() {
    initialize();
  }
}
