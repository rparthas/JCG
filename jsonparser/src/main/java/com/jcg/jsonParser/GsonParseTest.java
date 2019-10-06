package com.jcg.jsonParser;


import com.google.gson.Gson;

import java.io.FileReader;

public class GsonParseTest {

    private static final String filePath = "jsonTestFile.json";

    public static void main(String[] args) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(ClassLoader.getSystemResource(filePath).getFile())) {
            Person person = gson.fromJson(reader, Person.class);
            System.out.println(person.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
