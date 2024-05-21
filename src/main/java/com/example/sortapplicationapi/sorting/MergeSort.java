package com.example.sortapplicationapi.sorting;


import static com.example.sortapplicationapi.sorting.ConvertArrayToString.convertArrayToString;
import static com.example.sortapplicationapi.sorting.ConvertStringToArray.convertStringToArray;

public class MergeSort {

    public static String mergeSort(String numberString) {
        int[] numbers = convertStringToArray(numberString);
        return convertArrayToString(mergeSort(numbers, 0, numbers.length - 1));
    }

    private static int[] mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            int[] left = mergeSort(arr, low, mid);
            int[] right = mergeSort(arr, mid + 1, high);

            return merge(left, right);
        }

        return new int[]{arr[low]};
    }

    private static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                merged[k] = left[i];
                i++;
            } else {
                merged[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            merged[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            merged[k] = right[j];
            j++;
            k++;
        }

        return merged;
    }

}
