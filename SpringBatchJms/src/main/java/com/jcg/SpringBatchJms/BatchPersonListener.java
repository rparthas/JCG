package com.jcg.SpringBatchJms;

import com.jcg.SpringBatchJms.model.Person;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import java.util.List;

@Component
public class BatchPersonListener implements SessionAwareBatchMessageListener<ActiveMQTextMessage> {


    @Override
    public void onMessages(Session session, List<ActiveMQTextMessage> messages) throws JMSException {
        System.out.println(messages.size());
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        for (ActiveMQTextMessage message : messages) {
            Person person = (Person) converter.fromMessage(message);
            System.out.println(person.toString());
        }
    }
}
