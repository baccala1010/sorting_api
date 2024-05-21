package com.example.sortapplicationapi;

import lombok.*;

@Getter
@Setter
public class SortApiRequest {
    private String algorithm;
    private String numbers;

    public SortApiRequest(String algorithm, String numbers) {
        this.algorithm = algorithm;
        this.numbers = numbers;
    }
}
