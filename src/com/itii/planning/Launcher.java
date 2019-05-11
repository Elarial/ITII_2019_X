package com.itii.planning;

import java.awt.Menu;

import javax.swing.JFrame;

import com.itii.planning.gui.MainWindow;
import com.itii.planning.gui.MenuBar;


public class Launcher
{
  public static void main(String[] args)
  {
    MainWindow.getInstance();
    MenuBar.getInstance();
  }
}
