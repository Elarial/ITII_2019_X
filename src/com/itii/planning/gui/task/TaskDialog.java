package com.itii.planning.gui.task;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import com.itii.planning.gui.TablePanel;
import com.itii.planning.gui.calendar.CalendarPanel;


/**
 * Class représentant la boite de dialogue permetant d'ajouter une tache
 * @author Adrien
 */
public class TaskDialog extends JDialog {

    private JLabel taskNameLabel = new JLabel("Nom de la tâche : ");
    private JLabel dateLabel = new JLabel("Date dûe : ");
    private JLabel details = new JLabel ("Détails : ");
    private JTextField taskNameInput = new JTextField(10);
    private CalendarPanel calendar = new CalendarPanel();
    private JLabel dateInput = new JLabel(calendar.getFormatedDate());
    private JTextArea detailsInput = new JTextArea(5,20);
    private JButton cancelButton = new JButton("Annuler");
    private JButton okButton = new JButton("OK");


    /**
     * @param parent Frame dans laquelle sera rendu la boite de dialogue
     * @param task Tache à afficher dans la boite de dialogue
     */
    public TaskDialog(JFrame parent,Task task){
        super(parent, true);
        if (parent != null) {
            Dimension parentSize = parent.getSize();
            Point p = parent.getLocation();
            setLocation(p.x + parentSize.width / 4, p.y + parentSize.height / 4);
        }
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        Border border = BorderFactory.createLineBorder(Color.BLACK);
        taskNameInput.setBorder(border);
        dateInput.setBorder(border);

        detailsInput.setBorder(border);
        detailsInput.setLineWrap(true);
        detailsInput.setWrapStyleWord(true);
        detailsInput.setBorder(border);

        Insets topInset = new Insets(10,10,0,10);

        c.fill = GridBagConstraints.NONE;
        c.gridx=0;
        c.gridy=0;
        c.gridwidth=1;
        c.insets = topInset;
        this.add(taskNameLabel,c);
        c.fill = GridBagConstraints.NONE;
        c.gridx=0;
        c.gridy=1;
        c.gridwidth=1;
        c.insets = topInset;
        this.add(dateLabel,c);
        c.fill = GridBagConstraints.NONE;
        c.ipady=0;
        c.gridx=0;
        c.gridy=2;
        c.gridwidth=1;
        c.insets = topInset;
        this.add(details,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=1;
        c.gridy=0;
        c.gridwidth=3;
        c.insets = topInset;
        this.add(taskNameInput,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=1;
        c.gridy=1;
        c.gridwidth=1;
        c.insets = topInset;
        this.add(dateInput,c);
        c.fill = GridBagConstraints.VERTICAL;
        c.gridx=1;
        c.gridy=2;
        c.gridwidth=1;
        c.insets = topInset;
        this.add(detailsInput,c);
        c.fill = GridBagConstraints.BOTH;
        c.gridx=2;
        c.gridy=1;
        c.gridwidth=2;
        c.gridheight=2;
        c.insets = topInset;
        this.add(calendar.getDatePanel(),c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2 ;
        c.gridy = 3 ;
        c.gridwidth=1;
        c.gridheight=1;
        c.insets=new Insets(10,10,10,10);
        this.add(cancelButton,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 3 ;
        c.gridwidth=1;
        c.gridheight=1;
        c.insets=new Insets(10,0,10,10);
        this.add(okButton,c);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        if (task != null){
            taskNameInput.setText(task.getName());
            dateInput.setText(task.getDate());
            detailsInput.setText(task.getDetails());
        }

        calendar.getDatePanel().addActionListener(e->{

            dateInput.setText(calendar.getFormatedDate());
        });

        okButton.addActionListener(e -> {
            Task newTask = new Task(taskNameInput.getText(),dateInput.getText(),detailsInput.getText(),"unmarked");
            switch (this.getName()){

                case "newTask":
                    TablePanel.addTask(newTask);
                break;
                case "editTask":
                    TablePanel.editFocusedTask(newTask);

                break;

                case "markTask":
                    break;
                case "duplicateTask":
                    break;
                case "deleteTask":
                    break;
                    default:
                        throw new IllegalArgumentException("Invalid Text: "+this.getName());

            }
            setVisible(false);
            dispose();

        });
        cancelButton.addActionListener(e->{
            setVisible(false);
            dispose();
        });
    }

    /**
     * Méthode permettant de régler les champs de la boite de dialogue en fonction d'une tache
     * @param task Contenu de la tache qui sera copié dans la boite de dialogue.
     */
    public void setTaskContent(Task task){
        taskNameInput.setText(task.getName());
        dateInput.setText(task.getDate());
        detailsInput.setText(task.getDetails());

    }

}
