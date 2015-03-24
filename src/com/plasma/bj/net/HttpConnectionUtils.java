package com.plasma.bj.net;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by bj on 24.03.15.
 */
public class HttpConnectionUtils {

    static String ERR_MESSAGE = "Something went wrong, probably given URL is inappropriate or server does not respond, try again.";

    public static String performGetRequest(String url) {
        String response = "Something went wrong, probably server is down or you are requesting wrong URLs";
        if (url != null && !url.isEmpty()){
            String stringResponse = HttpConnectionUtils.get(url);
            if(!stringResponse.isEmpty()){
                try {
                    JSONObject obj = new JSONObject(stringResponse);
                    if (obj.get("msg") != null){
                        response = obj.getString("msg");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return response;
    }

    private static String get(String url){
        HttpURLConnection con;
        try {
            URL obj = new URL(parse(url));
            con = (HttpURLConnection) obj.openConnection();
        } catch (MalformedURLException e) {
            return ERR_MESSAGE;
        }
        catch (IOException e) {
            return ERR_MESSAGE;
        }

        StringBuilder response = new StringBuilder();
        if (con != null) {
            try {
                con.setRequestMethod("GET");
            } catch (ProtocolException e) {
                return ERR_MESSAGE;
            }
            BufferedReader in;
            try {
                int responseCode = con.getResponseCode();
                System.out.println("Sending GET request to URL: " + url + "\nResponse Code: " + responseCode);
                in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } catch (IOException e) {
                return ERR_MESSAGE;
            }
            try {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
            } catch (IOException e) {
                return ERR_MESSAGE;
            }
        }
        return response.toString();
    }

    private static String parse(String url) {
        if (!url.startsWith("http://")){
            return "http://" + url;
        }
        return url;
    }
}
