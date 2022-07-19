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

    static String queryParam = "";
    static String queryValue = "";

    static String query = "";


    static InputStream response = null;
    static String responseBody = "";

    // Setters
    public static void setURL(String myURL){
        url = myURL;
    }

    public static void addParameters(String myParam, String myValue){
        queryParam = myParam;
        queryValue = myValue;
        try {
            query = String.format(APIRequest.queryParam+"=%s",
                    URLEncoder.encode(APIRequest.queryValue, charset));
            if (url.contains("?")) {
                url = url + "&" + query;
            }else{
                url = url + "?" + query;
            }
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
        System.out.println("Using the following query ["+url+"]");
        URLConnection connection = null;
        try {
            connection = new URL(url).openConnection();
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

    public static void printRequestShortResponse(int length){
        try (Scanner scanner = new Scanner(response)) {
            responseBody = scanner.useDelimiter("\\A").next();
            String input = responseBody;//input string
            String output = "";         //substring containing first characters
            if (input.length() > length){
                output = input.substring(0, length);
            }
            else{output = input;}
            System.out.print("Bellow this line is the start of the response" +
                "\n------------------------------------------------------------\n"+
                output+"..."+
                "\n------------------------------------------------------------\n");
        }
    }

    public static boolean validateTextExistsInResponse(String textToBeSearched){
        //Returns True if text exists in the response. Be aware this is case-sensitive!
        //ForDebug: System.out.print("Is the game in the response: "+responseBody.toString().contains(textToBeSearched));
        return responseBody.toString().contains(textToBeSearched);
    }
}