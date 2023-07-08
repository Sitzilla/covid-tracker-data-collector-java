package com.evansitzes.coviddatacollector.service;

import com.evansitzes.coviddatacollector.CovidDataDTO;
import com.evansitzes.coviddatacollector.client.CdcCovidGeoClient;
import com.evansitzes.coviddatacollector.model.CdcCovidGeo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class DataCollectionService {

    private final CdcCovidGeoClient cdcCovidGeoClient;

    private final KafkaProducerService kafkaProducerService;

    public DataCollectionService(final CdcCovidGeoClient cdcCovidGeoClient, final KafkaProducerService kafkaProducerService) {
        this.cdcCovidGeoClient = cdcCovidGeoClient;
        this.kafkaProducerService = kafkaProducerService;
    }

    public void collect() {
        log.info("collecting data");
        final List<CdcCovidGeo> data = cdcCovidGeoClient.getAllData(3, 0, "case_month", "2020-02");

        log.info("collected data:");
        log.info(data.toString());

        // TODO transform data

        final List<CovidDataDTO> covidDataDTO = data.stream().map(x -> CovidDataDTO.builder()
                .ageGroup(x.getAgeGroup())
                .resCounty(x.getResCounty())
                .caseMonth(x.getCaseMonth())
                .build()).toList();

        kafkaProducerService.send("data-topic", UUID.randomUUID().toString(), covidDataDTO);
    }
}
