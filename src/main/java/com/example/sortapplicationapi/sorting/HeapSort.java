package com.example.sortapplicationapi.sorting;

import static com.example.sortapplicationapi.sorting.ConvertArrayToString.convertArrayToString;
import static com.example.sortapplicationapi.sorting.ConvertStringToArray.convertStringToArray;
import static com.example.sortapplicationapi.sorting.Swap.swap;

public class HeapSort {
    public static String heapSort(String numberString) {
        int[] numbers = convertStringToArray(numberString);
        heapSort(numbers);
        return convertArrayToString(numbers);
    }

    private static void heapSort(int[] arr) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }
}
