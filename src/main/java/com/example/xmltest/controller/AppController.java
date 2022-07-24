package com.example.xmltest.controller;

import com.example.xmltest.entity.ValueData;
import com.example.xmltest.services.AppServices;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AppController {

    private final AppServices appServices;

    @GetMapping("/assessment/{date}")
    public List<ValueData> getData(@PathVariable String date) {
        return appServices.getData(date);
    }

    @GetMapping("/assessment/aze")
    public List<ValueData> getAzeData(@RequestParam String date,@RequestParam String cry) {
        return appServices.getAzeData(date,cry);
    }

    @GetMapping("/assessment/aze/allDay")
    public List<ValueData> getAzeAllDayData(@RequestParam String cry) {
        return appServices.getAzeAlldayData(cry);
    }

    @DeleteMapping("/assessment/{date}")
    public List<ValueData> deleteData(@PathVariable String date) {
        return appServices.deletData(date);
    }

    @PostMapping("/assessment/{date}")
    public List<ValueData> addData(@PathVariable String date) throws IOException, JSONException {
        return appServices.addData(date);
    }

}
