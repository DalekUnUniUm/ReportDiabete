package com.gestionpatientui.gestionpatientui.controller;

import com.gestionpatientui.gestionpatientui.model.Generator;
import com.gestionpatientui.gestionpatientui.model.Patient;
import com.gestionpatientui.gestionpatientui.service.GeneratorService;
import com.gestionpatientui.gestionpatientui.service.PatientService;
import com.gestionpatientui.gestionpatientui.utils.ParseDate;
import com.gestionpatientui.gestionpatientui.utils.ReportFinal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.Period;

@Controller
public class GeneratorController {

    @Autowired
    private PatientService patientService ;

    @Autowired
    private GeneratorService generatorService ;


    @GetMapping("/generator/{patId}")
    public String resultReport(@PathVariable("patId") String patId, Model model){

        ParseDate parseDate = new ParseDate();
        ReportFinal reportFinal = new ReportFinal();

        Generator g  = new Generator();

        Patient p = patientService.getPatient(Integer.valueOf(patId));
        g.setTriggerTermCount(generatorService.getTriggerTerm(patId));
        g.setAge(parseDate.parseDate(p.getDateOfBirth()));
        g.setReportFinal(reportFinal.reportFinal(g.getAge().getYears(), g.getTriggerTerm(), p));

        model.addAttribute("generator",g);

        return "reportFinal" ;
    }

}
