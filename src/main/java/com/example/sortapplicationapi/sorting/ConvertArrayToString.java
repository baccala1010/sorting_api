package com.example.sortapplicationapi.sorting;

public class ConvertArrayToString {
    public static String convertArrayToString(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        for (int sum : numbers) {
            sb.append(sum).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
