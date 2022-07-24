package com.example.xmltest.repository;

import com.example.xmltest.entity.ValueData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;




@Repository
public interface AppRepository extends JpaRepository<ValueData,Long> {

    List<ValueData> findByToDate(String date);

    List<ValueData> deleteByToDate(String date);

    List<ValueData> findByToDateAndToCode(String date,String code);

    List<ValueData> findByToCode(String code);


}
