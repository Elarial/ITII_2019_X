package com.itii.planning.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import com.itii.planning.dataBase.TaskPersistence;
import com.itii.planning.gui.task.Task;

/**
 * Panel dans lequel sera gérer la vue Liste sous forme de table
 * @author Adrien
 */
public class TablePanel extends JPanel {

    private static JTable table;
    private static DefaultTableModel tableModel;
    private static ArrayList<Task> tasks;
    private static final TablePanel instance = new TablePanel();
    private TablePanel(){
        super();
        this.setLayout(new BorderLayout());



        String[] columnNames = { "Nom de la tâche", "Date dûe", "Détails" };
        tableModel = new DefaultTableModel(columnNames,0);
        table = new JTable(tableModel);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);

        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane,BorderLayout.CENTER);

        ListSelectionModel cellSelectionModel = table.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cellSelectionModel.addListSelectionListener(e -> {
            String selectedData ;

            int[] selectedRow = table.getSelectedRows();
            int[] selectedColumns = table.getSelectedColumns();


            for (int i = 0; i < selectedRow.length; i++) {
                for (int j = 0; j < selectedColumns.length; j++) {
                    selectedData = (String) table.getValueAt(selectedRow[i], selectedColumns[j]);
                    System.out.println("Selected: " + selectedData);
                }
            }
        });
        tasks = new ArrayList<>(TaskPersistence.getTasks());
        addTasks(tasks);
    }

    public static TablePanel getInstance(){
        return instance;

    }

    /**
     * @return La table rendu dans le panel
     */
    public static JTable getTable(){
        return table;
    }

    /**
     * Méthode permettant d'ajouter une tache
     * @param task Tache à ajouter
     */
    public static void addTask(Task task){
        tableModel.addRow(new Object[]{task.getName(),task.getDate(),task.getDetails()});
        tasks.add(task);
        TaskPersistence.addTask(task);
    }

    /**
     * Méthode permettant d'ajouter plusieurs taches
     * @param tasks Listes de taches à ajouter.
     */
    public static void addTasks(ArrayList<Task> tasks){
        for (Task task : tasks) {
            tableModel.addRow(new Object[]{task.getName(),task.getDate(),task.getDetails()});
            //tasks.add(task);
        }
    }

    /**
     * Méthode permettant d'ajouter une tache à un certain index
     * @param task
     * @param pos
     */
    public static void addTask (Task task, int pos){
        tableModel.insertRow(pos,new Object[]{task.getName(),task.getDate(),task.getDetails()});
        tasks.add(pos,task);
        TaskPersistence.addTask(task);
    }

    /**
     * Methode permettant de supprimer la tache séléctionnée.
     */
    public static void deleteFocusedTask(){
        Task task = getFocusedTask();
        TaskPersistence.deleteTask(task);
        tasks.remove(task);
        tableModel.removeRow(table.getSelectedRow());
    }

    /**
     * @return La tache sélectionnée par l'utilisateur
     */
    public static Task getFocusedTask(){
        int selectedRow = table.getSelectedRow();
        return tasks.get(selectedRow);
    }

    /**
     * Méthode permettant de modifier une tache
     * @param task tache devant être modifiée.
     */
    public static void editFocusedTask(Task task){
        deleteFocusedTask();
        addTask(task);
    }

    /**
     * Méthode permettant de dupliquer la tache sélectionnée.
     */
    public static void duplicateFocusedTask(){
        Task existingTask = getFocusedTask();
        Task duplicateTask = new Task(existingTask.getName(),existingTask.getDate(),existingTask.getDetails(),existingTask.getState());
        addTask(duplicateTask,getTable().getSelectedRow()+1);
    }


}

