package com.jcg.SpringBatchJms.config;

import com.jcg.SpringBatchJms.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.jms.JmsItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import java.util.stream.IntStream;

@EnableJms
@Configuration
@EnableBatchProcessing
public class SpringBatchJmsConfig {

    public static final Logger logger = LoggerFactory.getLogger(SpringBatchJmsConfig.class.getName());


    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public JmsListenerContainerFactory<?> queueListenerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setMessageConverter(messageConverter());
        return factory;
    }

    @Bean
    public MessageConverter messageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }


    @Bean
    public JmsItemReader<Person> personJmsItemReader(MessageConverter messageConverter) {
        JmsItemReader<Person> personJmsItemReader = new JmsItemReader<>();
        personJmsItemReader.setJmsTemplate(jmsTemplate);
        personJmsItemReader.setItemType(Person.class);
        return personJmsItemReader;
    }

    @Bean
    public FlatFileItemWriter<Person> personFlatFileItemWriter() {
        FlatFileItemWriter<Person> personFlatFileItemWriter = new FlatFileItemWriter<>();
        personFlatFileItemWriter.setLineAggregator(person -> person.toString());
        personFlatFileItemWriter.setLineSeparator(System.lineSeparator());
        personFlatFileItemWriter.setResource(new FileSystemResource("person.txt"));
        return personFlatFileItemWriter;
    }

    @Bean
    public Job importUserJob() {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(jobExecutionListener())
                .flow(step1())
                .end()
                .build();
    }

    private Step step1() {
        return stepBuilderFactory.get("step1")
                .<Person, Person>chunk(10)
                .reader(personJmsItemReader(messageConverter()))
                .writer(personFlatFileItemWriter())
                .build();
    }

    @Bean
    public JobExecutionListener jobExecutionListener() {
        return new JobExecutionListener() {
            @Override
            public void beforeJob(JobExecution jobExecution) {
                IntStream.rangeClosed(1,100).forEach(token->{
                    Person[] people = {new Person("Jack", "Ryan"), new Person("Raymond", "Red"), new Person("Olivia", "Dunham"),
                            new Person("Walter", "Bishop"), new Person("Harry", "Bosch")};
                    for (Person person : people) {
                        jmsTemplate.convertAndSend(person);
                    }
                });
                Person person = new Person();
                jmsTemplate.convertAndSend(person);
            }

            @Override
            public void afterJob(JobExecution jobExecution) {

            }
        };
    }

}

