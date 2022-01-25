package com.evansitzes.coviddatacollector.controller;

import com.evansitzes.coviddatacollector.service.DataCollectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DataCollectionController {

    private final DataCollectionService dataCollectionService;

    public DataCollectionController(final DataCollectionService dataCollectionService) {
        this.dataCollectionService = dataCollectionService;
    }

    @PostMapping("/api/trigger-collection")
    public void triggerDataCollection() {
        dataCollectionService.collect();
    }
}
