package com.itii.planning.gui;

import javax.swing.JFrame;



public class MainWindow extends JFrame
{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  public static MainWindow INSTANCE;

  public static MainWindow getInstance(){
    if(INSTANCE == null) {
      INSTANCE = new MainWindow();
     // INSTANCE.initialize();
    }
    return INSTANCE;
  }

  private MainWindow()
  {
    initialize();
  }

  public void initialize()
  {

      this.setSize(600,480);


      this.setVisible(true);
  }
}
