package com.gestionpatientui.gestionpatientui.utils;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.Period;

public class ParseDate {

    public Period parseDate(String date){

        int age = 0;

        String year = "" ;
        String day = "";
        String month = "";

        for(int i = 0 ; i < 4 ; i++){
            year = year + date.charAt(i);
            }

        for(int i = 5 ; i < 7 ; i++){
            day = day + date.charAt(i);
        }
        for(int i = 8 ; i < 10 ; i++){
            if(date.charAt(i) != '0')
                month = month + date.charAt(i);
        }

        LocalDate birthDate = LocalDate.of(Integer.valueOf(year), Integer.valueOf(day),Integer.valueOf(month));
        LocalDate currentDate = LocalDate.now();


        return Period.between(birthDate,currentDate) ;

    }

}
