package com.example.sortapplicationapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/sort")
public class SortApiController {

    @Autowired
    private SortApiService sortApiService;

    @PostMapping
    public SortApiResponse sort(@RequestBody SortApiRequest sortApiRequest) {
        String sortedNumbers = sortApiService.sort(sortApiRequest.getAlgorithm(), sortApiRequest.getNumbers());
        long executionTime = sortApiService.measureSortTime(sortApiRequest.getAlgorithm(), sortApiRequest.getNumbers());

        return new SortApiResponse(sortedNumbers, executionTime);
    }

}

