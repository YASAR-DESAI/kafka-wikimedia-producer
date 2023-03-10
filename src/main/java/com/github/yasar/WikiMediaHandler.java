package com.github.yasar;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

public class WikiMediaHandler implements EventHandler {

    private static Logger log = LoggerFactory.getLogger(WikiMediaHandler.class);
    private KafkaTemplate<String, String> kafkaTemplate;
    private String topic;

    public WikiMediaHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic ;
    }

    @Override
    public void onOpen() throws Exception {

    }

    @Override
    public void onClosed() throws Exception {

    }

    @Override
    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
        log.info(String.format("Event Data: %s ", messageEvent.getData()));

        kafkaTemplate.send(topic, messageEvent.getData());
        //kafkaTemplate.flush();
    }

    @Override
    public void onComment(String s) throws Exception {

    }

    @Override
    public void onError(Throwable throwable) {

    }
}
