package com.AutomationProject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

/**
 * This class exists only the calculate an interest.
 * (Its main utility is to be used to test the main class)
 */
public class APIRequest {
    public static boolean executeApiRequest(String myURL, String myParam1, String myParam2){

        //Set parameters
        String charset = java.nio.charset.StandardCharsets.UTF_8.name(); // Or just "UTF-8"
        String url = myURL;
        String param1 = myParam1;
        String param2 = myParam2;

        //Create the query
        String query = null;
        String URLWithQuery = null;
        try {
            query = String.format("param1=%s&param2=%s",
                    URLEncoder.encode(param1, charset),
                    URLEncoder.encode(param2, charset));
            URLWithQuery = url + "?" + query;
            System.out.println("Using the following url + query ["+URLWithQuery+"]");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //Sending the query
        URLConnection connection = null;
        try {
            connection = new URL(URLWithQuery).openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        connection.setRequestProperty("Accept-Charset", charset);
        InputStream response = null;
        try {
            response = connection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Print response
        try (Scanner scanner = new Scanner(response)) {
            String responseBody = scanner.useDelimiter("\\A").next();
            System.out.print("Bellow this line is the response" +
                    "\n------------------------------------------------------------\n"+
                    responseBody+
                    "\n------------------------------------------------------------\n");
        }

        return true;
    }
}