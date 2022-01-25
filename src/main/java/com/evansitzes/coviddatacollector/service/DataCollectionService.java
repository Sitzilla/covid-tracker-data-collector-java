package com.evansitzes.coviddatacollector.service;

import com.evansitzes.coviddatacollector.CdcCovidGeoClient;
import com.evansitzes.coviddatacollector.model.CdcCovidGeo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service
public class DataCollectionService {

    private final CdcCovidGeoClient cdcCovidGeoClient;

    public DataCollectionService(final CdcCovidGeoClient cdcCovidGeoClient) {
        this.cdcCovidGeoClient = cdcCovidGeoClient;
    }

    public void collect() {
        log.info("collecting data");
        final List<CdcCovidGeo> data = cdcCovidGeoClient.getAllData(3, 0, "case_month", "2020-02");

        // TODO process data
    }
}
