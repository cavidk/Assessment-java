package com.example.xmltest.XmlUrl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ValCurs {

    private String Description;

    private ArrayList<ValType> ValType;

    private String Date;

    private String Name;
}
