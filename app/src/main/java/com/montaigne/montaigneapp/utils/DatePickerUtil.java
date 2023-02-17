package com.montaigne.montaigneapp.utils;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;

import java.util.Calendar;
import java.util.TimeZone;

public class DatePickerUtil extends DatePickerDialog {

    public DatePickerUtil(
            Context context,
            OnDateSetListener dateListener
            ) {
        super(context,
                AlertDialog.THEME_DEVICE_DEFAULT_DARK,
                dateListener,
                Calendar.getInstance(TimeZone.getDefault()).get(Calendar.YEAR),
                Calendar.getInstance(TimeZone.getDefault()).get(Calendar.MONTH),
                Calendar.getInstance(TimeZone.getDefault()).get(Calendar.DAY_OF_MONTH));
    }

    public void create() {
        setCancelable(false);
        show();
    }
}
