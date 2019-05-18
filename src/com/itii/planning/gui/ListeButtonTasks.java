/**
 * 
 */
package com.itii.planning.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author user
 *
 */
public class ListeButtonTasks extends JPanel
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private static ListeButtonTasks INSTANCE;
  
  public static ListeButtonTasks getInstance(){
    if(INSTANCE == null) {
      INSTANCE = new ListeButtonTasks();
    }
    return INSTANCE;
  }
  
  private void initialize(){
    
    this.setLayout(new GridBagLayout());
    
    GridBagConstraints c = new GridBagConstraints();
    
    c.fill = GridBagConstraints.HORIZONTAL;
    c.anchor = GridBagConstraints.CENTER;
    
    c.gridy = 0 ;
    JButton buttonCreer     = new JButton("Créer");
    this.add(buttonCreer,c);
    c.gridy = 1 ;
    JButton buttonEditer    = new JButton("Editer");
    
    this.add(buttonEditer,c);
    c.gridy = 2 ;
    JButton buttonMarquer   = new JButton("Marquer");
    this.add(buttonMarquer,c);
    JButton buttonDupliquer = new JButton("Dupliquer");
    c.gridy = 3 ;
    this.add(buttonDupliquer,c);
    c.gridy = 4 ;
    JButton buttonSupprimer = new JButton("Supprimer");
    this.add(buttonSupprimer,c);
    
    
    
    
    
    
    
  }
  
  private ListeButtonTasks() {
    
    initialize();
  }
}
