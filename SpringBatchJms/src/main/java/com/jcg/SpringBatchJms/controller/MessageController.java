package com.jcg.SpringBatchJms.controller;

import com.jcg.SpringBatchJms.BatchMessageListenerContainer;
import com.jcg.SpringBatchJms.BatchPersonListener;
import com.jcg.SpringBatchJms.model.Person;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;
import java.util.Objects;
import java.util.stream.IntStream;

@RestController
public class MessageController {

    BatchMessageListenerContainer container = new BatchMessageListenerContainer();

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private BatchPersonListener batchPersonListener;

    @RequestMapping(value = "/start")
    public String startListener() {

        try {
            Connection conn = Objects.requireNonNull(jmsTemplate.getConnectionFactory()).createConnection();
            Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            container.setBatchSize(200);
            container.setCacheLevel(BatchMessageListenerContainer.CACHE_CONSUMER);
            container.setConnectionFactory(jmsTemplate.getConnectionFactory());
            container.setDestination(session.createQueue(jmsTemplate.getDefaultDestinationName()));
            container.setMessageListener(batchPersonListener);
            container.setConcurrentConsumers(5);
            container.setMaxConcurrentConsumers(10);
            container.initialize();
            container.start();
        } catch (JMSException | NullPointerException e) {
            e.printStackTrace();
            return "Failed";
        }
        return "started";
    }


    @RequestMapping(value = "/stop")
    public String stopListener() {
        container.stop();
        return "Stopped";
    }

    @RequestMapping(value = "/send/{count}")
    public String sendMessage(@PathVariable int count) {
        IntStream.rangeClosed(1, count).forEach(token -> {
            Person[] people = {new Person("Jack", "Ryan"), new Person("Raymond", "Red"), new Person("Olivia", "Dunham"),
                    new Person("Walter", "Bishop"), new Person("Harry", "Bosch")};
            for (Person person : people) {
                jmsTemplate.convertAndSend(person);
            }
        });
        Person person = new Person();
        jmsTemplate.convertAndSend(person);
        return "sent";
    }
}
