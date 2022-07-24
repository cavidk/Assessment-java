package com.example.xmltest.mapper;

import com.example.xmltest.XmlUrl.Valute;
import com.example.xmltest.entity.ValueData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")


public abstract class AppMapper {

    @Mapping(source = "code", target = "toCode")
    public abstract ValueData toValutes(Valute request);


    public abstract List<ValueData> toApps(List<Valute> request);

}
