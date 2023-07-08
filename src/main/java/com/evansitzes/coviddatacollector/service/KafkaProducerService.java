package com.evansitzes.coviddatacollector.service;

import com.evansitzes.coviddatacollector.CovidDataDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class KafkaProducerService {

    private final KafkaTemplate<String, List<CovidDataDTO>> kafkaTemplate;

    public KafkaProducerService(final KafkaTemplate<String, List<CovidDataDTO>> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(final String topicName, final String key, final List<CovidDataDTO> value) {
        final var future = kafkaTemplate.send(topicName, key, value);

        future.whenComplete((sendResult, exception) -> {
            if (exception != null) {
                future.completeExceptionally(exception);
            } else {
                future.complete(sendResult);
            }
            log.info("Covid data to Kafka topic: {}", value);
        });
    }
}