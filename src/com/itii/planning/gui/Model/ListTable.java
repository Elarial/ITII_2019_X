package com.itii.planning.gui.Model;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ListTable extends JTable {
    public JTable table;
    public ListTable(){
        super();

         //String [] _titles = {"Nom de la tâche","Date dûe","Détails"};
         //DefaultTableModel _tableModel = new DefaultTableModel(_titles,2);
         //this.setModel(_tableModel);
         //this.dataModel = _tableModel;

        String[][] data = {
                { "Kundan Kumar Jha", "4031", "CSE" },
                { "Anand Jha", "6014", "IT" }
        };
        String[] columnNames = { "Name", "Roll Number", "Department" };
        table = new JTable(data, columnNames);
        table.setCellSelectionEnabled(true);
        ListSelectionModel cellSelectionModel = table.getSelectionModel();
        cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        cellSelectionModel.addListSelectionListener(e -> {
            String selectedData = null;

            int[] selectedRow = table.getSelectedRows();
            int[] selectedColumns = table.getSelectedColumns();

            for (int i = 0; i < selectedRow.length; i++) {
                for (int j = 0; j < selectedColumns.length; j++) {
                    selectedData = (String) table.getValueAt(selectedRow[i], selectedColumns[j]);
                }
            }
            System.out.println("Selected: " + selectedData);
        });

    }
}
