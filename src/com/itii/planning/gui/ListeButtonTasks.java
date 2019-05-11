/**
 * 
 */
package com.itii.planning.gui;

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
  
  public void initialize(){
    JButton buttonCreer     = new JButton("Créer");
    JButton buttonEditer    = new JButton("Editer");
    JButton buttonMarquer   = new JButton("Marquer");
    JButton buttonDupliquer = new JButton("Dupliquer");
    JButton buttonSupprimer = new JButton("Supprimer");
    
    GridBagConstraints c = new GridBagConstraints();
    
    
    this.add(buttonCreer);
    this.add(buttonEditer);
    this.add(buttonMarquer);
    this.add(buttonDupliquer);
    this.add(buttonSupprimer);
    
    
    
  }
  
  private ListeButtonTasks() {
    initialize();
  }
}
