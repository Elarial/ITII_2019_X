package com.itii.db;


import java.util.ArrayList;

public class LauncherDb {
	public static void main(String[] args) {

		ArrayList<String> TasksList = new ArrayList<String>();

		// SQLite.deleteTable();
		SQLite.createTable();
		//SQLite.emptyTable();
		// SQLite.fillTable();
		
		SQLite.addTask(7, "Test", "13/05/2019", "Test", "#1");
		
		TasksList = SQLite.listTask();
		System.out.println(TasksList);

	}

}
