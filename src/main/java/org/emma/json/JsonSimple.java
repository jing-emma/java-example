package org.emma.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

public class JsonSimple {

    public static boolean isValidJson(String json) {
        JSONParser parser = new JSONParser();
        try {
            parser.parse(json);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    public static void parseJson() throws ParseException {
        String json = "{\n" +
                "  \"product\": \"Live JSON generator\",\n" +
                "  \"version\": 3.1,\n" +
                "  \"releaseDate\": \"2014-06-25T00:00:00.000Z\",\n" +
                "  \"demo\": true,\n" +
                "  \"person\": {\n" +
                "    \"id\": 12345,\n" +
                "    \"name\": \"John Doe\",\n" +
                "    \"phones\": {\n" +
                "      \"home\": \"800-123-4567\",\n" +
                "      \"mobile\": \"877-123-1234\"\n" +
                "    },\n" +
                "    \"email\": [\n" +
                "      \"jd@example.com\",\n" +
                "      \"jd@example.org\"\n" +
                "    ],\n" +
                "    \"dateOfBirth\": \"1980-01-02T00:00:00.000Z\",\n" +
                "    \"registered\": true,\n" +
                "    \"emergencyContacts\": [\n" +
                "      {\n" +
                "        \"name\": \"Jane Doe\",\n" +
                "        \"phone\": \"888-555-1212\",\n" +
                "        \"relationship\": \"spouse\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"name\": \"Justin Doe\",\n" +
                "        \"phone\": \"877-123-1212\",\n" +
                "        \"relationship\": \"parent\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";

        JSONParser parser = new JSONParser();
        JSONObject root = (JSONObject) parser.parse(json);
        String product = (String) root.get("product");
        System.out.println("parseJson string expecting [Live JSON generator], get [" + product + "]");
        JSONObject person = (JSONObject) root.get("person");
        JSONArray emails = (JSONArray) person.get("email");
        System.out.println("parseJson array expecting [jd@example.com], get [" + emails.get(0) + "]");
        System.out.println("parseJson array expecting [jd@example.org], get [" + emails.get(1) + "]");

    }

    public static String createJson() {
        JSONObject root = new JSONObject();
        root.put("user_code", "12345");
        JSONArray products = new JSONArray();
        JSONObject prod1 = new JSONObject();
        prod1.put("id", 123);
        prod1.put("name", "DT");
        prod1.put("displayable", true);
        JSONObject prod2 = new JSONObject();
        prod2.put("id", 890);
        prod2.put("name", "DDC");
        products.add(prod1);
        products.add(prod2);
        root.put("products", products);
        System.out.println(root.toJSONString());
        return root.toJSONString();
    }




    /*********** Test ***********/

    public static void main(String[] args) throws ParseException {
        validJsonTest();
        parseJson();
        createJson();

    }

    private static void validJsonTest() {
        String validJson = "{\n" +
                "  \"product\": \"Live JSON generator\",\n" +
                "  \"version\": 3.1,\n" +
                "  \"releaseDate\": \"2014-06-25T00:00:00.000Z\",\n" +
                "  \"demo\": true\n" +
                "}";
        Assert.assertEquals(true, isValidJson(validJson));
        Assert.assertEquals(false, isValidJson("invalid json"));
    }

}
