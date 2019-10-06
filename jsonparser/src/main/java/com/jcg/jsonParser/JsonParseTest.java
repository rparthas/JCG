package com.jcg.jsonParser;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;

public class JsonParseTest {

    private static final String filePath = "jsonTestFile.json";

    public static void main(String[] args) {

        try (FileReader reader = new FileReader(ClassLoader.getSystemResource(filePath).getFile())) {
            // read the json file


            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            // get a String from the JSON object
            String firstName = (String) jsonObject.get("firstname");
            System.out.println("The first name is: " + firstName);

            // get a number from the JSON object
            long id = (long) jsonObject.get("id");
            System.out.println("The id is: " + id);

            // get an array from the JSON object
            JSONArray lang = (JSONArray) jsonObject.get("languages");

            // take the elements of the json array
            for (int i = 0; i < lang.size(); i++) {
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
            JSONObject structure = (JSONObject) jsonObject.get("job");
            System.out.println("Into job structure, name: " + structure.get("name"));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
