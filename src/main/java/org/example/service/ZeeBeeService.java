package org.example.service;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.camunda.MyZeeBeeClient;
import org.example.models.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

@Component
public class ZeeBeeService {

    @Autowired
    final MyZeeBeeClient client;

    public ZeeBeeService(MyZeeBeeClient client) {
        this.client = client;
    }

    public void startFlow(Application application){

        client.getClient().newCreateInstanceCommand()
                //.bpmnProcessId("restAPIDemo")
                .bpmnProcessId("accountOpening")
                .latestVersion()
                .variables(application)
                .send()
                .join();
    }

    public void sendMsg(Application application){
        String topic = "accountOnboardingTopic";
        //String topic = "test-new";
        String message = "";//application.toString();

        ObjectMapper mapper = new ObjectMapper();

        try {
            message =  mapper.writeValueAsString(application);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<String, String>(properties);
        producer.send(new ProducerRecord<String, String>(topic, message));
        System.out.println("Message Sent");
        producer.close();
    }
}
