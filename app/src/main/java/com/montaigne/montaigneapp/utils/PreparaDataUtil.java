package com.montaigne.montaigneapp.utils;

public class PreparaDataUtil {

    private static String preparaDate(int data) {
        if (data < 10) {
            return "0" + String.valueOf(data);
        }
        return String.valueOf(data);
    }

    public static String preparaData(int selectedYear, int selectedMonth, int selectedDay) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder
                .append(preparaDate(selectedDay))
                .append("/")
                .append(preparaDate(selectedMonth))
                .append("/")
                .append(preparaDate(selectedYear))
                .toString();
    }
}
