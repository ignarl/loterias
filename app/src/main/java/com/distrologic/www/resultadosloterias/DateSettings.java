package com.distrologic.www.resultadosloterias;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;
import android.widget.Toast;

/**
 * Created by nac on 16/01/2017.


public class DateSettings implements DatePickerDialog.OnDateSetListener {

    Context context;
    public DateSettings(Context context){
        this.context = context;
    }


    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        Toast.makeText(context, "Fecha seleccionada: " + dayOfMonth + "-" + monthOfYear + "-" + year,Toast.LENGTH_LONG).show();

    }
}
 */