package com.gestionpatientui.gestionpatientui.utils;

import com.gestionpatientui.gestionpatientui.model.Patient;


public class ReportFinal {

    public String reportFinal(int age, int triggerTermCount, Patient p){
        String reportFinal = "" ;

        if(triggerTermCount >= 1)
            reportFinal = "Patient " + p.getLastName() + " " + p.getFirstName() + "(age " + age + ") diabetes assessment is : None" ;

        if(triggerTermCount >= 2 && age > 30)
            reportFinal = "Patient " + p.getLastName() + " " + p.getFirstName() + "(age " + age + ") diabetes assessment is : Borderline" ;

        if(p.getSexe().equals("M") && age <= 30 && triggerTermCount >= 3 || p.getSexe().equals("F") && age <= 30 && triggerTermCount >= 4 || age > 30 && triggerTermCount > 6)
            reportFinal = "Patient " + p.getLastName() + " " + p.getFirstName() + "(age " + age + ") diabetes assessment is : In danger" ;

        if(p.getSexe().equals("M") && age <= 30 && triggerTermCount >= 5 || p.getSexe().equals("F") && age <= 30 && triggerTermCount >= 7 || age > 30 && triggerTermCount > 8)
            reportFinal = "Patient " + p.getLastName() + " " + p.getFirstName() + "(age " + age + ") diabetes assessment is : Early onset" ;

        return reportFinal ;
    }

}
