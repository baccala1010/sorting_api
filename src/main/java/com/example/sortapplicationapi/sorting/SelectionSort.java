package com.example.sortapplicationapi.sorting;

import static com.example.sortapplicationapi.sorting.ConvertArrayToString.convertArrayToString;
import static com.example.sortapplicationapi.sorting.ConvertStringToArray.convertStringToArray;
import static com.example.sortapplicationapi.sorting.Swap.swap;

public class SelectionSort {

    public static String selectionSort(String numberString) {
        int[] numbers = convertStringToArray(numberString);
        for (int i = 0; i < numbers.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[minIndex]) {
                    minIndex = j;
                }
            }
            swap(numbers, i, minIndex);
        }
        return convertArrayToString(numbers);
    }
}
