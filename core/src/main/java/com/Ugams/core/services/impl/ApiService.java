package com.Ugams.core.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ApiService {
    private static final Logger log = LoggerFactory.getLogger(ApiService.class);
    private static final String USER_AGENT = "Firefox/26.0";
    public static String getJson(String url) {
        try {
            log.info("inside api service method");
            URL obj = new URL(url);
            HttpsURLConnection http = (HttpsURLConnection) obj.openConnection();
            http.setRequestMethod("GET");
            http.setRequestProperty("User-Agent", USER_AGENT);
                BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
                log.info("bufferreader output"+br);
                String input;
                StringBuffer response;
                response = new StringBuffer();
                while ((input = br.readLine()) != null) {
                    response.append(input);
                }
                br.close();
                return response.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
       return "" ;
    }
}
