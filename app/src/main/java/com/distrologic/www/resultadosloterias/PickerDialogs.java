package com.distrologic.www.resultadosloterias;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

import static com.distrologic.www.resultadosloterias.R.id.txtDate;

/**
 * Created by nac on 16/01/2017.


public class PickerDialogs extends DialogFragment {




    @Override
    public void onCreateDialog(Bundle savedInstanceState){
        DateSettings dateSettings = new DateSettings(getActivity());
        Calendar calendar = Calendar.getInstance();
        int year = Calendar.get(Calendar.YEAR);
        int month = Calendar.get(Calendar.MONTH);
        int day = Calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog dialog;
        dialog = new DatePickerDialog(getActivity(),dateSettings,year,month,day);


        return dialog;
    }
}
 */

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    public DatePickerFragment(DatePicker view, int year, int month, int day) {
        // Do something with the date chosen by the user
        String dateSelected;
        dateSelected = day+"/"+month+"/"+year;
        EditText txtDate = (EditText)findViewById(R.id.txtDate); 
        txtDate.setText(dateSelected);
    }
}