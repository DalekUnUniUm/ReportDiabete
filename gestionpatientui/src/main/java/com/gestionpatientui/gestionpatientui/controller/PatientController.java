package com.gestionpatientui.gestionpatientui.controller;

import com.gestionpatientui.gestionpatientui.model.History;
import com.gestionpatientui.gestionpatientui.model.Patient;
import com.gestionpatientui.gestionpatientui.service.HistoryService;
import com.gestionpatientui.gestionpatientui.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PatientController {
    @Autowired
    private PatientService patientService ;

    @Autowired
    private HistoryService historyService ;

    @GetMapping("/")
    public String home(Model model){
        Iterable<Patient> listPatient = patientService.getPatients();
        model.addAttribute("patients",listPatient);
        return "home" ;
    }
    @GetMapping("/sheetPatient/{id}")
    public String sheetPatient(@PathVariable("id") final int id, Model model){
        Patient p = patientService.getPatient(id);
        List<History> h = historyService.getHistorys(id);
        model.addAttribute("patient", p);
        model.addAttribute("historys",h);
        /**On teste si une note existe déjà, si non: on donne l'Id du patient pour le patId des notes**/
        if(h.size() == 0){
            model.addAttribute("patId",p.getId());
        }else{
            model.addAttribute("patId",h.get(0).getPatId());
        }

        return "sheetPatient" ;
    }

    @GetMapping("/updatePatient/{id}")
    public String updatePatient(@PathVariable("id") final int id, Model model){
        Patient p = patientService.getPatient(id);
        model.addAttribute("patient", p);
        return "updatePatientForm" ;
    }

    @GetMapping("/addPatient")
    public String addPatient(Model model){
        Patient p = new Patient();
        model.addAttribute("patient", p) ;
        return "addPatientForm" ;
    }

    @PostMapping("/addPatient")
    public ModelAndView addPatient(@ModelAttribute Patient patient){
        patientService.addPatient(patient);
        return new ModelAndView("redirect:/");
    }
}
