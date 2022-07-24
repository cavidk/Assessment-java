package com.example.xmltest.XmlUrl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ValType {

    private String Type;

    private ArrayList<Valute> Valute;
}
