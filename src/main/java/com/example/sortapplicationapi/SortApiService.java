package com.example.sortapplicationapi;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import static com.example.sortapplicationapi.sorting.HeapSort.heapSort;
import static com.example.sortapplicationapi.sorting.InsertionSort.insertionSort;
import static com.example.sortapplicationapi.sorting.MergeSort.mergeSort;
import static com.example.sortapplicationapi.sorting.QuickSort.quickSort;
import static com.example.sortapplicationapi.sorting.SelectionSort.selectionSort;

@Service
@Getter
@Setter
@Component
public class SortApiService {

    public String sort(String algorithm, String numbers) {
        switch (algorithm) {
            case "merge":
                return mergeSort(numbers);
            case "heap":
                return heapSort(numbers);
            case "insertion":
                return insertionSort(numbers);
            case "selection":
                return selectionSort(numbers);
            case "quick":
                return quickSort(numbers);
            default:
                throw new IllegalArgumentException("Unknown sorting algorithm: " + algorithm);
        }
    }

//    public long measureSortTime(String algorithm, String numbers) {
//        long startTime = System.currentTimeMillis();
//        String sortedNumbers = sort(algorithm, numbers);
//        long endTime = System.currentTimeMillis();
//        return endTime - startTime;
//    }

    public long measureSortTime(String algorithm, String numbers) {
        return measureTime(() -> sort(algorithm, numbers));
    }

    private static long measureTime(Runnable task) {
        long startTime = System.nanoTime();
        task.run();
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        System.out.println("Elapsed time: " + elapsedTime + " ns");
        return elapsedTime;
    }


}
