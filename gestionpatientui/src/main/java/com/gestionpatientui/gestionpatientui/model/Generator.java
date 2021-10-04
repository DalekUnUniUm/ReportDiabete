package com.gestionpatientui.gestionpatientui.model;

import lombok.Data;

import java.time.Period;

@Data
public class Generator {

    private Period age ;
    private int triggerTerm ;
    private String reportFinal ;

    public void setAge(Period age) {
        this.age = age;
    }

    public void setTriggerTermCount(int triggerTermCount) {
        this.triggerTerm = triggerTermCount;
    }
    public Period getAge() {
        return age;
    }

    public int getTriggerTerm() {
        return triggerTerm;
    }

    public void setReportFinal(String reportFinal) {
        this.reportFinal = reportFinal;
    }

    public String getReportFinal() {
        return reportFinal;
    }
}
