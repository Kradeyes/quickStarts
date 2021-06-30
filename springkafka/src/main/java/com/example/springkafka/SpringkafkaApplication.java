package com.example.springkafka;

import com.example.springkafka.consumer.ConsumerChannels;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(ConsumerChannels.class)
public class SpringkafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringkafkaApplication.class, args);
    }

}
