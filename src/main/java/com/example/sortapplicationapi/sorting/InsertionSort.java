package com.example.sortapplicationapi.sorting;

import static com.example.sortapplicationapi.sorting.ConvertArrayToString.convertArrayToString;
import static com.example.sortapplicationapi.sorting.ConvertStringToArray.convertStringToArray;

public class InsertionSort {
    public static String insertionSort(String numberString) {
        int[] numbers = convertStringToArray(numberString);
        for (int i = 1; i < numbers.length; i++) {
            int key = numbers[i];
            int j = i - 1;

            while (j >= 0 && numbers[j] > key) {
                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = key;
        }

        return convertArrayToString(numbers);
    }

}
