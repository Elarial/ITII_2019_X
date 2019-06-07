package com.itii.planning.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class MainWindow extends JFrame {
    private static MainWindow instance;
    public static MainWindow getInstance()
    {
        if(instance == null)
            instance = new MainWindow();
        return instance;
    }
    private MainWindow(){
        super("JavaSwingApp");
        initialize();
    }
    private void initialize()
    {

        Dimension windowDimension = new Dimension(1000,1000);
        //this.setSize(windowDimension);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
        this.setLayout(new GridLayout(3,1));
        JLabel headerLabel = new JLabel("",JLabel.CENTER );
        JLabel statusLabel = new JLabel("",JLabel.CENTER);

         */

        this.validate();
        this.repaint();

        final MainMenuBar menuBar = new MainMenuBar();
        final DropDownMenu dropDownMenu = new DropDownMenu();
        dropDownMenu.setPreferredSize(new Dimension(960,30));

        final NorthPanel northPanel = new NorthPanel();

        final PanelContainer panelContainer = new PanelContainer(windowDimension);

        JButton testbutton = new JButton("test");
        panelContainer.add(testbutton);

        final CenterPanel centerPanel = new CenterPanel();

        final MonthlyPanel monthlyPanel = new MonthlyPanel();
        final WeeklyPanel weeklyPanel = new WeeklyPanel();
        final RightPanel rightPanel = new RightPanel();

        this.setJMenuBar(menuBar);
        this.add(panelContainer);



        Border border = BorderFactory.createLineBorder(Color.BLACK);
        northPanel.setBorder(border);
        panelContainer.add(northPanel,BorderLayout.PAGE_START);
        panelContainer.setBorder(border);
        centerPanel.setBorder(border);
        panelContainer.add(centerPanel);
        rightPanel.setBorder(border);
        panelContainer.add(rightPanel,BorderLayout.LINE_END);

        northPanel.add(dropDownMenu,BorderLayout.CENTER);

        centerPanel.add(ListPanel.getInstance(),"Liste");
        centerPanel.add(monthlyPanel,"Mois");
        centerPanel.add(weeklyPanel,"Semaine");



        dropDownMenu.addActionListener (e -> {
            String box = dropDownMenu.getSelectedItem().toString();
            CardLayout cardLayout = (CardLayout) centerPanel.getLayout();
            cardLayout.show(centerPanel, box);
        });
        this.setContentPane(panelContainer);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
