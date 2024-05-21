package com.example.sortapplicationapi.sorting;

public class ConvertStringToArray {
    public static int[] convertStringToArray(String numberString) {
        String[] numbersStrArr = numberString.split(" ");
        int[] numbers = new int[numbersStrArr.length];
        for (int i = 0; i < numbersStrArr.length; i++) {
            numbers[i] = Integer.parseInt(numbersStrArr[i]);
        }
        return numbers;
    }
}
