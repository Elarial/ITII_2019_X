package com.itii.planning.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.itii.planning.gui.task.TaskDialog;

/**
 * Class représentant le panneau de droite contenant les boutons d'interaction.
 * @author Adrien
 */
public class RightPanel extends JPanel implements ActionListener {
    RightPanel(){
        super();
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;

        JButton createButton = new JButton("Créer");
        createButton.setName("createButton");
        JButton editButton = new JButton("Editer");
        editButton.setName("editButton");
        JButton markButton = new JButton("Marquer");
        markButton.setName("markButton");
        JButton duplicateButton = new JButton("Dupliquer");
        duplicateButton.setName("duplicateButton");
        JButton deleteButton = new JButton("Supprimer");
        deleteButton.setName("deleteButton");

        c.gridy = 0;
        this.add(createButton,c);
        this.add(Box.createHorizontalStrut(10));
        c.gridy = 1;
        c.insets = new Insets(10,0,0,0);
        this.add(editButton,c);
        c.gridy = 2;
        c.insets = new Insets(10,0,0,0);
        this.add(markButton,c);
        c.gridy = 3;
        c.insets = new Insets(10,0,0,0);
        this.add(duplicateButton,c);
        c.gridy = 4;
        c.insets = new Insets(10,0,0,0);
        this.add(deleteButton,c);


        createButton.addActionListener(this);
        editButton.addActionListener(this);
        markButton.addActionListener(this);
        duplicateButton.addActionListener(this);
        deleteButton.addActionListener(this);
    }

    /**
     * Méthode gérant les évennements lors des actions sur les boutons.
     * @param e Ecouteur de l'évennement
     */
    public void actionPerformed(ActionEvent e) {
            JButton source = (JButton)e.getSource();


            switch (source.getName()){
                case "createButton" :
                    execCreateButton();
                    break;
                case "editButton":
                    execEditButton();
                    break;
                case "markButton":
                    break;
                case "duplicateButton":
                    execDuplicateButton();
                    break;
                case "deleteButton":
                    execDeleteButton();
                    break;
                default :
                    throw new IllegalArgumentException("Invalid Text: "+source.getName());
            }
    }
    public void execCreateButton(){
        TaskDialog taskDialog= new TaskDialog((JFrame)getTopLevelAncestor(),null);
        taskDialog.setTitle("Nouvelle tâche");
        taskDialog.setName("newTask");
        taskDialog.pack();
        taskDialog.setVisible(true);
    }
    public void execEditButton(){
        TaskDialog taskDialog= new TaskDialog((JFrame)getTopLevelAncestor(), TablePanel.getFocusedTask());
        taskDialog.setTitle("Editer une tâche");
        taskDialog.setName("editTask");
        taskDialog.setTaskContent(TablePanel.getFocusedTask());
        taskDialog.pack();
        taskDialog.setVisible(true);
    }
    public void execDuplicateButton(){
        TablePanel.duplicateFocusedTask();
    }
    public void execDeleteButton(){
        TablePanel.deleteFocusedTask();
    }
}
