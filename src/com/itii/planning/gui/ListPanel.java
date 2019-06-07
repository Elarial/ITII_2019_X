package com.itii.planning.gui;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import com.itii.planning.gui.Model.ListTable;
import javax.swing.event.ListSelectionEvent;
import com.itii.planning.gui.Model.ListTable;
import com.itii.planning.gui.task.Task;

public class ListPanel extends JPanel {
    private static JTable table;
    private static DefaultTableModel tableModel;
    public JTable table2;

    private static final ListPanel instance = new ListPanel();
    private ListPanel(){
        super();
        this.setLayout(new BorderLayout());



        String[] columnNames = { "Nom de la tâche", "Date dûe", "Détails" };
        tableModel = new DefaultTableModel(columnNames,0);
        table = new JTable(tableModel);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);

        table2 = new ListTable();
        JScrollPane scrollPane = new JScrollPane(table);
        this.add(scrollPane,BorderLayout.CENTER);

        ListSelectionModel cellSelectionModel = table.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cellSelectionModel.addListSelectionListener(e -> {
            String selectedData = null;
            String selectedTask [] = null;

            int[] selectedRow = table.getSelectedRows();
            int[] selectedColumns = table.getSelectedColumns();

            for (int i = 0; i < selectedRow.length; i++) {
                for (int j = 0; j < selectedColumns.length; j++) {
                    selectedData = (String) table.getValueAt(selectedRow[i], selectedColumns[j]);
                    System.out.println("Selected: " + selectedData);
                }
            }

        });

    }

    public static ListPanel getInstance(){
        return instance;


/*
        this.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_ALWAYS) ;
        this.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_ALWAYS);
*/


    }
    public static JTable getTable(){
        return table;
    }
    public static void addTask(Task task){
        tableModel.addRow(new Object[]{task.getName(),task.getDate(),task.getDetails()});
    }
    public static void deleteFocusedTask(){
        tableModel.removeRow(table.getSelectedRow());
    }
    public static Task getFocusedTask(){
        int selectedRow = table.getSelectedRow();
        String cellContent [] = new String[table.getColumnCount()+1];
        for (int i=0;i<table.getColumnCount();i++){
            System.out.print(table.getValueAt(selectedRow,i));
            cellContent[i]= (String)table.getValueAt(selectedRow,i);
        }
        return new Task(cellContent[0],cellContent[1],cellContent[2]);
    }
    public static void editFocusedTask(Task task){
        deleteFocusedTask();
        addTask(task);
    }
    public static void duplicateFocusedTask(){
        addTask(getFocusedTask());
    }


}

