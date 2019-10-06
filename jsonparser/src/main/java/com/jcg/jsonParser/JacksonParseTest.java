package com.jcg.jsonParser;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;

public class JacksonParseTest {
    private static final String filePath = "jsonTestFile.json";

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try (FileReader reader = new FileReader(ClassLoader.getSystemResource(filePath).getFile())) {
            Person person = mapper.readValue(reader, Person.class);
            System.out.println(person.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
