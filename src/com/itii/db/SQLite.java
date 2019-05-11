package com.itii.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
			System.out.println("Creation : Done ");
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
				stmt.setString(4, "#"+i);
				stmt.executeUpdate();
			}
			System.out.println("Filling : Done");
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

		} catch (SQLException e) {
			System.out.println("problème dans la suppression des données dans la table.");
		}

	}
}
