package com.tanda.cps_demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@Slf4j
public class GwRequestController {

    private final KafkaTemplate<String, GwRequest> gwRequestKafkaTemplate;

    public GwRequestController(KafkaTemplate<String, GwRequest> gwRequestKafkaTemplate) {
        this.gwRequestKafkaTemplate = gwRequestKafkaTemplate;
    }

    @PostMapping("message")
    public ResponseEntity<?> createGwRequest(@RequestBody GwRequest gwRequest) {
        log.info("Composing kafka message");

        CompletableFuture<SendResult<String, GwRequest>> sendResultCompletableFuture = gwRequestKafkaTemplate
                .send("gw_request", gwRequest)
                .whenComplete((sendResult, throwable) -> log.info("Kafka message sent"))
                .exceptionally(throwable -> {
                    log.error(throwable.getMessage());
                    return null;
                });

        log.info("Complete");

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
