package com.itii.planning.gui.task;

/**
 * Class représentant notre modèle de ce qu'est une tache.
 * @author Adrien
 */
public class Task {
    private static int _count = 0;
    private int _id;
    private String _name,_date,_details,_state;

    /**
     * Constructeur par défaut permettant de créer une nouvelle tache avec un id autoincrémenté
     * @param name Nom de la tache
     * @param date Date de fin de tache
     * @param details Détails de la tache
     * @param state Etat de la tache.
     */
    public Task(String name,String date, String details, String state){
        _name = name;
        _date = date;
        _details = details;
        _state = state;
        _id=++_count;
    }

    /**
     * Constructeur surchargé permettant de créer des taches avec un id spécifique
     * @param id Identifiant de la tache
     * @param name Nom de la tache
     * @param date Date de fin de tache
     * @param details Détails de la tache
     * @param state Etat de la tache.
     */
    public Task (int id,String name,String date, String details, String state){
        _id = id;
        _name = name;
        _date = date;
        _details = details;
        _state = state;
        if(id > _count){
            _count = id;
        }
    }

    /**
     * @return Identifiant de la tache
     */
    //Accesseurs
    public int getId () {return _id;}

    /**
     * @return Nombre de taches créer
     */
    public static int get_count(){return _count;}

    /**
     * @return Nom de la tache
     */
    public String getName(){return _name;}

    /**
     * @return Date de la tache
     */
    public String getDate(){
        return _date;
    }

    /**
     * @return Détails de la tache
     */
    public String getDetails(){
        return _details;
    }

    /**
     * @return Etat de la tache
     */
    public String getState (){return _state;}
}
