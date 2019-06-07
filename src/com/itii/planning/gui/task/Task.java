package com.itii.planning.gui.task;

public class Task {
    private String _name,_date,_details;

    public Task(String name,String date, String details){
        _name = name;
        _date = date;
        _details = details;
    }

    public String getName(){
        return _name;
    }
    public String getDate(){
        return _date;
    }
    public String getDetails(){
        return _details;
    }
}
