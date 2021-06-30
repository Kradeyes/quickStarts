package com.example.springkafka.consumer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MessageListener {
    private Logger logger = LogManager.getLogger(MessageListener.class);

    @StreamListener(ConsumerChannels.DEMO)
    public void listener(String message) {
        logger.info("Сообщение всем : " + message);
    }
}
