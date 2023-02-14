package com.montaigne.montaigneapp.utils;

import android.widget.EditText;

import androidx.annotation.NonNull;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class editTextInputParser {
    public static int getInt(@NonNull EditText editText) {
        return (int) getFloat(editText);
    }

    public static float getFloat(@NonNull EditText editText) {
        String value = String.valueOf(editText.getText());
        return value.equals("") ? 0 : Float.parseFloat(value);
    }

    public static Date getDate(@NonNull EditText editText) throws ParseException {
        return parseDate(editText.getText().toString());
    }

    public static Date parseDate(@NonNull String string) throws ParseException {
        return new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse(string);
    }

    @NonNull
    public static Date getCurrentDate() {
        return Calendar.getInstance().getTime();
    }

    public static void setValue(@NonNull EditText editText, Integer value) {
        editText.setText(String.valueOf(value));
    }

    public static void setValue(@NonNull EditText editText, Float value){
        editText.setText(String.valueOf(value));
    }

    public static void setValue(@NonNull EditText editText, @NonNull Date date) {
        editText.setText(date.toString());
    }

    public static void setValue(@NonNull EditText editText, @NonNull String string) {
        editText.setText(string);  // método apenas para fins de sobrecarga
    }
}
