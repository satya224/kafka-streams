package com.example.kafkastream.config;

import com.example.commonlibrary.dto.*;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerde;

import java.util.HashMap;
import java.util.Map;

import static org.apache.kafka.streams.StreamsConfig.*;

@Configuration
@EnableKafka
@EnableKafkaStreams
public class KafkaConfig {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Value(value = "${spring.kafka.consumer.topic}")
    private String inputTopic;


    @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
    KafkaStreamsConfiguration kStreamsConfig() {
        Map<String, Object> props = new HashMap<>();
        props.put(APPLICATION_ID_CONFIG, "kafka-stream");
        props.put(BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        props.put(DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(DEFAULT_VALUE_SERDE_CLASS_CONFIG, JsonSerde.class);
        props.put(JsonDeserializer.TRUSTED_PACKAGES, "com.example.commonlibrary.dto");

        return new KafkaStreamsConfiguration(props);
    }

    @Bean
    public KStream<String, Health> kStream(StreamsBuilder kStreamBuilder) {
        KStream<String, Health> stream = kStreamBuilder.stream(inputTopic);
        stream.mapValues(Health::getSubscriber).to("subscriber_topic", Produced.with(Serdes.String(), new JsonSerde<>(Subscriber.class)));
        stream.mapValues(Health::getPatient).to("patient_topic", Produced.with(Serdes.String(), new JsonSerde<>(Patient.class)));
        stream.mapValues(Health::get_case).to("case_topic", Produced.with(Serdes.String(), new JsonSerde<>(Case.class)));
        stream.mapValues(Health::getService).to("service_topic", Produced.with(Serdes.String(), new JsonSerde<>(Service.class)));
        return stream;
    }

}
