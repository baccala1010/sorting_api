package com.example.sortapplicationapi.sorting;

import static com.example.sortapplicationapi.sorting.ConvertArrayToString.convertArrayToString;
import static com.example.sortapplicationapi.sorting.ConvertStringToArray.convertStringToArray;
import static com.example.sortapplicationapi.sorting.Swap.swap;

public class QuickSort {

    public static String quickSort(String numberString) {
        int[] numbers = convertStringToArray(numberString);
        quickSort(numbers, 0, numbers.length - 1);
        return convertArrayToString(numbers);
    }

    private static void quickSort(int[] arr, int from, int to) {
        if (from < to) {
            int partitionIndex = partition(arr, from, to);

            quickSort(arr, from, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, to);
        }
    }

    private static int partition(int[] arr, int from, int to) {
        int rightIndex = to;
        int leftIndex = from;

        int pivot = arr[from + (to - from) / 2];

        while (leftIndex <= rightIndex) {
            while (arr[leftIndex] < pivot) {
                leftIndex++;
            }
            while (arr[rightIndex] > pivot) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swap(arr, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }
}
