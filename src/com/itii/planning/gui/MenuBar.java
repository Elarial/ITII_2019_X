/**
 * 
 */
package com.itii.planning.gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
   
   JMenuItem itemFichierQuitter = new JMenuItem("Quitter");
   
   JMenuItem itemEditionCreer     = new JMenuItem("Créer");
   JMenuItem itemEditionEditer    = new JMenuItem("Editer");
   JMenuItem itemEditionMarquer   = new JMenuItem("Marquer");
   JMenuItem itemEditionDupliquer = new JMenuItem("Dupliqer");
   JMenuItem itemEditionSupprimer = new JMenuItem("Supprimer");
   
   JMenuItem itemVueListe   = new JMenuItem("Liste");
   JMenuItem itemVueSemaine = new JMenuItem("Semaine");
   JMenuItem itemVueMois    = new JMenuItem("Mois");
   
   
   menuFichier.add(itemFichierQuitter);
   
   menuEdition.add(itemEditionCreer);
   menuEdition.add(itemEditionEditer);
   menuEdition.add(itemEditionMarquer);
   menuEdition.add(itemEditionDupliquer);
   menuEdition.add(itemEditionSupprimer);
   
   menuView.add(itemVueListe);
   menuView.add(itemVueSemaine);
   menuView.add(itemVueMois);
   
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
