package com.itii.planning.gui;

import javax.swing.JFrame;



public class MainWindow extends JFrame
{
  /**
   * CardLayout
   */
  private static final long serialVersionUID = 1L;

  public static MainWindow INSTANCE;

  public static MainWindow getInstance(){
    if(INSTANCE == null) {
      INSTANCE = new MainWindow();
     
    }
    return INSTANCE;
  }

  private MainWindow()
  {
    initialize();
  }

  private void initialize()
  {

      this.setSize(600,480);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      this.setJMenuBar(MenuBar.getInstance());
      
      this.getContentPane().add(MainPanel.getInstance());
      
      
      
      this.setVisible(true);
  }
}
