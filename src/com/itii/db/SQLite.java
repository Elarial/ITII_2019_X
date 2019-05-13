package com.itii.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLite {

	private static final String TABLE_NAME = "Tasks";
	private static final String FIELD_ID = "id";
	private static final String FIELD_NAME = "name";
	private static final String FIELD_DATE = "date";
	private static final String FIELD_DETAILS = "details";
	private static final String FIELD_STATE = "state";

	public static void createTable() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:database/planning.db");
			statement = connection.createStatement();
			statement.setQueryTimeout(15);
			statement.execute("create table if not exists " + TABLE_NAME + " ( " + FIELD_ID
					+ " integer primary key autoincrement, " // Primary
					// key
					+ FIELD_NAME + " string, " // Name
					+ FIELD_DATE + " text, " // Details
					+ FIELD_DETAILS + " text, " // date as ISO8601 strings ("YYYY-MM-DD HH:MM:SS.SSS").
					+ FIELD_STATE + " boolean " + " )");
			connection.close();
		} catch (SQLException e) {
			System.out.println("problème dans la création de la table.");
			e.printStackTrace();
		}

	}

	public static void deleteTable() {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:database/planning.db");
			statement = connection.createStatement();
			statement.setQueryTimeout(15);
			statement.execute("drop table if exists " + TABLE_NAME);
			System.out.println("Delete : Done ");
			connection.close();
		} catch (SQLException e) {
			System.out.println("problème dans la suppression de la table.");
			e.printStackTrace();
		}

	}

	public static void fillTable() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:database/planning.db");
			PreparedStatement stmt = connection.prepareStatement("insert into " + TABLE_NAME + " ( " + FIELD_NAME + ","
					+ FIELD_DATE + "," + FIELD_DETAILS + "," + FIELD_STATE + " ) " + "values ( ?, ?, ?, ?) ");
			stmt.setQueryTimeout(15);
			for (int i = 1; i < 11; i++) {
				stmt.setString(1, "TP #" + i);
				stmt.setString(2, "2018-04-" + i + " 12:00");
				stmt.setString(3, "Task " + i);
				stmt.setString(4, "#" + i);
				stmt.executeUpdate();
			}
			System.out.println("Filling : Done");
			connection.close();
		} catch (SQLException e) {
			System.out.println("problème dans l'insertion d'une nouvelle enrée dans la table.");
		}
	}

	public static void emptyTable() {
		Connection connection = null;
		Statement statement = null;

		try {
			connection = DriverManager.getConnection("jdbc:sqlite:database/planning.db");
			statement = connection.createStatement();
			statement.setQueryTimeout(15);
			statement.execute("delete from " + TABLE_NAME);
			System.out.println("Empty : Done ");
			connection.close();

		} catch (SQLException e) {
			System.out.println("problème dans la suppression des données dans la table.");
		}

	}

	public static ArrayList<String> listTask() {
		Connection connection = null;
		Statement statement = null;
		ResultSet queryResult = null;
		ArrayList<String> TasksList = new ArrayList<String>();

		try {
			connection = DriverManager.getConnection("jdbc:sqlite:database/planning.db");
			statement = connection.createStatement();
			statement.setQueryTimeout(15);
			queryResult = statement.executeQuery("select * from " + TABLE_NAME);
			System.out.println("Tasks retrieve with success ");
			while (queryResult.next()) {
				TasksList.add(queryResult.getString(FIELD_ID));
				TasksList.add(queryResult.getString(FIELD_NAME));
				TasksList.add(queryResult.getString(FIELD_DATE));
				TasksList.add(queryResult.getString(FIELD_DETAILS));
				TasksList.add(queryResult.getString(FIELD_STATE));
				TasksList.add("/");
			}
			connection.close();

		} catch (SQLException e) {
			System.out.println("problème dans la recherche des données dans la table.");
		}

		return TasksList;
	}
	
	public static void addTask(int id, String name, String date, String details, String state) {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:database/planning.db");
			statement = connection.createStatement();
			statement.setQueryTimeout(15);
			statement.executeUpdate("insert into " + TABLE_NAME + " values(" + id + ", \"" + name + "\", \"" + date + "\", \"" + details + "\", \"" + state + "\")");
			System.out.println("Data added with success");
			connection.close();

		} catch (SQLException e) {
			System.out.println("problème dans l'insertion des données dans la table.");
		}
		
	}
}
