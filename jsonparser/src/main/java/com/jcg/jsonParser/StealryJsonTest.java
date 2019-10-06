package com.jcg.jsonParser;


import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileReader;
import java.util.Iterator;

public class StealryJsonTest {
    private static final String filePath = "jsonTestFile.json";

    public static void main(String[] args) {
        try (FileReader reader = new FileReader(ClassLoader.getSystemResource(filePath).getFile())) {
            JSONTokener tokener = new JSONTokener(reader);
            JSONObject object = new JSONObject(tokener);

            String firstName = (String) object.get("firstname");
            System.out.println("The first name is: " + firstName);

            // get a number from the JSON object
            int id = (int) object.get("id");
            System.out.println("The id is: " + id);

            // get an array from the JSON object
            JSONArray lang = (JSONArray) object.get("languages");

            // take the elements of the json array
            for (int i = 0; i < lang.length(); i++) {
                System.out.println("The " + i + " element of the array: " + lang.get(i));
            }
            Iterator i = lang.iterator();

            // take each value from the json array separately
            while (i.hasNext()) {
                JSONObject innerObj = (JSONObject) i.next();
                System.out.println("language " + innerObj.get("lang") +
                        " with level " + innerObj.get("knowledge"));
            }
            // handle a structure into the json object
            JSONObject structure = (JSONObject) object.get("job");
            System.out.println("Into job structure, name: " + structure.get("name"));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}