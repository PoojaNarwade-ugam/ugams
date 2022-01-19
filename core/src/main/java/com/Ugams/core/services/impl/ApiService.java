package com.Ugams.core.services.impl;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ApiService {
    private static final String USER_AGENT = "Mozilla/5.0";
    public static String readJson(String url) {

        try {

            URL obj = new URL(url);
            HttpsURLConnection http = (HttpsURLConnection) obj.openConnection();
            http.setRequestMethod("GET");
            http.setRequestProperty("User-Agent", USER_AGENT);
            int responseCode = http.getResponseCode();
                BufferedReader in = new BufferedReader(new InputStreamReader(http.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {

                    response.append(inputLine);
                }
                in.close();
                return response.toString();

        } catch (IOException e) {

            e.printStackTrace();
        }

       return "" ;
    }
}
