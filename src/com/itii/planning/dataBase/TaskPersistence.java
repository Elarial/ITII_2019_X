package com.itii.planning.dataBase;
import com.itii.planning.gui.task.Task;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Classe static permettant l'interaction abstraite avec la base de données.
 * @author Adrien .
 */
public class TaskPersistence {

        private static final String TABLE_NAME = "Tasks";
        private static final String FIELD_ID = "id";
        private static final String FIELD_NAME = "name";
        private static final String FIELD_DATE = "date";
        private static final String FIELD_DETAILS = "details";
        private static final String FIELD_STATE = "state";

    /**
     * Methode permettant de créer la table et la base de données, qu'elles existent ou non.
     */
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

    /**
     * Méthode permettant de supprimer la table de la base de données.
     */
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

    /**
     * Méthode permettant d'ajouter des valeurs à la base de données
     */
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

    /**
     * Méthode permettant de vider le contenu de la table.
     */
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


    /**
     * Méthode permettant d'ajouter une tâche à la base de données
     * @param task Objet tâche à ajouter à la base de données.
     */
        public static void addTask(Task task) {
            Connection connection = null;
            Statement statement = null;
            try {
                connection = DriverManager.getConnection("jdbc:sqlite:database/planning.db");
                statement = connection.createStatement();
                statement.setQueryTimeout(15);
                statement.executeUpdate("insert into "
                        + TABLE_NAME
                        + " values("
                        + task.getId()
                        + ", \""
                        + task.getName()
                        + "\", \""
                        + task.getDate()
                        + "\", \""
                        + task.getDetails()
                        + "\", \""
                        + task.getState()
                        + "\")");

                connection.close();

            } catch (SQLException e) {
                System.out.println("problème dans l'insertion des données dans la table.");
                System.out.println(e.getMessage());

            }
            System.out.println(task.getId());
            System.out.println("Data added with success");
        }

    /**
     * Méthode permettant de connaitre les taches contenues en base de données.
     * @return Retourne toutes les taches présentent dans la base de données.
     */
        public static ArrayList<Task> getTasks (){
            Connection connection;
            Statement statement;
            ArrayList <Task> tasksList = new ArrayList<>();
            try {
                connection = DriverManager.getConnection("jdbc:sqlite:database/planning.db");
                statement = connection.createStatement();
                statement.setQueryTimeout(15);
                ResultSet rs = statement.executeQuery("select * from " + TABLE_NAME);
                while (rs.next()){
                    tasksList.add(new Task(
                            rs.getInt(FIELD_ID),
                            rs.getString(FIELD_NAME),
                            rs.getString(FIELD_DATE),
                            rs.getString(FIELD_DETAILS),
                            rs.getString(FIELD_DETAILS)));
                }
                connection.close();
            }catch (SQLException e){
                System.out.println("erreur à la lecture de la table");
                System.out.println(e.getMessage());
            }
            System.out.println("Data added with success");
            return tasksList;
        }

    /**
     * Méthode permettant d'effacer une tache de la base de données.
     * @param task Tache à supprimer de la base de données.
     */
        public static void deleteTask (Task task){
            Connection connection;
            Statement statement;
            try {
                connection = DriverManager.getConnection("jdbc:sqlite:database/planning.db");
                statement = connection.createStatement();
                statement.setQueryTimeout(15);
                statement.executeUpdate("DELETE FROM " + TABLE_NAME + " WHERE " + FIELD_ID +"="+task.getId());
                System.out.println(task.getId());
                connection.close();
            }catch (SQLException e){
                System.out.println("erreur à la suppression d'une ligne de la table");
                System.out.println(e.getMessage());
            }
            System.out.println("Data deleted with success");
        }
    }
