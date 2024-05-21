package com.example.sortapplicationapi;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SortApiResponse {
    private String sortedNumbers;
    private long executionTime;

    public SortApiResponse(String sortedNumbers, long executionTime) {
        this.sortedNumbers = sortedNumbers;
        this.executionTime = executionTime;
    }
}
