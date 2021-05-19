package com.griddynamics.practical.stringblocks;

public class TextBlocksExample {
    public static void main(String[] args) {
        String uglyJson = "{\n" +
                "   \"name\": \"John\",\n" +
                "   \"lastName: \"Doe\",\n" +
                "   \"properties\": [\n" +
                "       {\n" +
                "           \"type\": \"car\",\n" +
                "           \"price\": 32000\n" +
                "       },\n" +
                "       {\n" +
                "           \"type\": \"bike\",\n" +
                "           \"price\": 200\n" +
                "       }\n" +
                "   ]\n" +
                "}";
        // base indentation is 16 white spaces
        // first new line (the one after first """) is always escaped
        String beautifulJson = """
                {
                   "name": "John",
                   "lastName: "Doe",
                   "properties": [
                       {
                           "type": "car",
                           "price": 32000
                       },
                       {
                           "type": "bike",
                           "price": 200
                       }
                   ]
                }""";
        System.out.println(beautifulJson.equals(uglyJson));

        String escapedNewLine = """
                A very long text with escaped new line which is helpful in code \
                to achieve better readability but not needed in the final String""";

        System.out.println(escapedNewLine);

        String escapedWhiteSpaces = """
               A text with three spaces at   
               the end of each line   
               that are trimmed in result String   
               but preserved   
               here   \s
               Three spaces before escaping are preserved and one added because of "\\s"  """;
        System.out.println(escapedWhiteSpaces);

    }
}
