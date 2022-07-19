package com.AutomationProject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

/**
 * This class exists only to calculate an interest.
 * (Its main utility is to be used to test the main class)
 */
public class APIRequest {
    static String charset = java.nio.charset.StandardCharsets.UTF_8.name(); // Or just "UTF-8"
    static String url;

    static String param1 = "";
    static String param2 = "";
    static String category1 = "";
    static String category2 = "";

    static String query = "";
    static String URLWithQuery = "";

    static InputStream response = null;
    static String responseBody = "";

    // Setters
    public static void setURL(String myURL){
        url = myURL;
    }
    public static void setParameters(String myCategory1,String myParam1,String myCategory2,String myParam2){
        category1 = myCategory1;
        category2 = myCategory2;
        param1 = myParam1;
        param2 = myParam2;
    }

    public static void concatenateURLWithQuery(){
        //Create the query. (This part transform the parameters in the correct form to be used in the query.
        try {
            query = String.format(category1+"=%s&"+category2+"=%s",
                    URLEncoder.encode(param1, charset),
                    URLEncoder.encode(param2, charset));
            URLWithQuery = url + "?" + query;
            System.out.println("Using the following url + query ["+URLWithQuery+"]");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    // Getters
    public static InputStream getApiRequestResponse(){
        return response;
    }

    public static boolean validateResponseExist(){
        if (response == null) {
            return FALSE;
        } else {
            return TRUE;
        }
    }

    // Methods
    public static void executeGETApiRequest(){
        //Sending the query
        URLConnection connection = null;
        try {
            connection = new URL(URLWithQuery).openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

        connection.setRequestProperty("Accept-Charset", charset);

        try {
            response = connection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printRequestResponse(){
        try (Scanner scanner = new Scanner(response)) {
            responseBody = scanner.useDelimiter("\\A").next();
            System.out.print("Bellow this line is the response" +
                    "\n------------------------------------------------------------\n"+
                    responseBody+
                    "\n------------------------------------------------------------\n");
        }
    }

    public static boolean validateTextExistsInResponse(String textToBeSearched){
        //Returns True if text exists in the response. Be aware this is case-sensitive!
        //System.out.print("Response3:"+responseBody.toString().contains(textToBeSearched));
        return responseBody.contains(textToBeSearched);
    }
}