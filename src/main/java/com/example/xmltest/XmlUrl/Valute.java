package com.example.xmltest.XmlUrl;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Valute {

    private double Value;

    private String Code;

    private String Nominal;

    private String Name;
}
