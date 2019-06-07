package com.itii.planning.gui.calendar;

import org.jdatepicker.*;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class CalendarPanel {
    private JDatePickerImpl _datePicker;
    private JDatePanelImpl _datePanel;
    private UtilDateModel _model;
    public CalendarPanel(){
        _model = new UtilDateModel();
        Properties props = new Properties();
        props.put("text.today","Aujourd'hui");
        props.put("text.month","Mois");
        props.put("text.year","Année");
        _datePanel = new JDatePanelImpl(_model,props);
        _datePicker = new JDatePickerImpl(_datePanel,new DateLabelFormatter());
        _model.setSelected(true);

    }
    public JDatePickerImpl getDatePicker(){
        return _datePicker;
    }
    public  JDatePanelImpl getDatePanel(){
        return  _datePanel;
    }
    public UtilDateModel getModel (){
        return _model;
    }

    public String getFormatedDate(){
        Date selectedDate = _model.getValue();
        SimpleDateFormat sdfmt = new SimpleDateFormat("dd/MM/yyyy");
        return sdfmt.format(selectedDate);
    }

}