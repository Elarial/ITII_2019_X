/**
 * 
 */
package com.itii.planning.gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 * @author Jacques
 *
 */
public class MenuBar extends JMenuBar
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  private static MenuBar INSTANCE;
  
  private MenuBar() {
    initialize();
  }

  public void initialize()
  {
   JMenu menuFichier =  new JMenu("Fichier");
   JMenu menuEdition =  new JMenu("Edition");
   JMenu menuView    =  new JMenu("Vue");
   JMenu menuAide    =  new JMenu("Aide");
   
   
   this.add(menuFichier);
   this.add(menuEdition);
   this.add(menuView);
   this.add(menuAide);
  }
  
  public static MenuBar getInstance()
  {
    if (INSTANCE == null) {
      INSTANCE = new MenuBar();
    }
    return INSTANCE;
  }
}
