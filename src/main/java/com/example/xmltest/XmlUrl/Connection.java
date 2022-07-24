package com.example.xmltest.XmlUrl;


import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connection {
    public static void main(String[] args) throws IOException, JSONException {
        URL url = new URL("https://www.cbar.az/currencies/26.09.2022.xml");
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        http.setRequestProperty("Accept", "application/xml");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(http.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        JSONObject xmlJSONObj = XML.toJSONObject(String.valueOf(response));
        http.disconnect();
        Gson gson = new Gson();
        Root root =gson.fromJson(String.valueOf(xmlJSONObj),Root.class);

        System.out.println(root.getValCurs().getValType().get(1).getValute().get(2).getName());
        System.out.println(root.getValCurs().getValType().get(1).getValute().get(2).getNominal());
        System.out.println(root.getValCurs().getValType().get(1).getValute().get(2).getValue());

    }
}
