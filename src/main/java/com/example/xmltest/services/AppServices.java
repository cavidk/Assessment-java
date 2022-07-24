package com.example.xmltest.services;

import com.example.xmltest.XmlUrl.Root;
import com.example.xmltest.XmlUrl.Valute;
import com.example.xmltest.entity.ValueData;
import com.example.xmltest.mapper.AppMapper;
import com.example.xmltest.repository.AppRepository;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppServices {

    private final AppRepository appRepository;
    private final AppMapper appMappers;


    public List<ValueData> addData(String date) throws IOException, JSONException {
        URL url = new URL("https://www.cbar.az/currencies/" + date + ".xml");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
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
        Root root = gson.fromJson(String.valueOf(xmlJSONObj), Root.class);

        ArrayList<Valute> testValute = root.getValCurs().getValType().get(1).getValute();

        List<ValueData> AppTest = appMappers.toApps(testValute);


        for (int i = 0; i < AppTest.size(); i++) {
            AppTest.get(i).setToDate(date);
        }

        List<ValueData> list = appRepository.findByToDate(date);
        if (list.size() > 0) {
            return list;
        } else {
            List<ValueData> saveTest = appRepository.saveAll(AppTest);
            return saveTest;
        }

    }

    public List<ValueData> getData(String date)  {
        return appRepository.findByToDate(date);
    }

    public List<ValueData> getAzeData(String date,String code)  {
        return appRepository.findByToDateAndToCode(date,code);
    }

    public List<ValueData> getAzeAlldayData(String code)  {
        return appRepository.findByToCode(code);
    }

    public List<ValueData> deletData(String date)  {
        return appRepository.deleteByToDate(date);
    }
}
