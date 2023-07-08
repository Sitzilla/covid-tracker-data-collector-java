package com.evansitzes.coviddatacollector.service;

import com.evansitzes.coviddatacollector.CovidDataDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class KafKaTopicListeners {

    @KafkaListener(topics = "data-topic", groupId = "covid-data")
    public void consume(final List<CovidDataDTO> covidDataDTO) {

        log.info("Consuming covid data: {}", covidDataDTO);
        log.info(String.valueOf(covidDataDTO));
    }
}