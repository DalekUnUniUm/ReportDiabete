package com.patient.patient.controller;

import com.patient.patient.model.PatientModel;
import com.patient.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.Optional;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService ;

    /**Endpoint for add patient**/
    @PostMapping("/patient/add")
    public PatientModel addPatientModel(@RequestBody PatientModel patientModel){
        return patientService.savePatientModel(patientModel) ;
    }

    /**Endpoint to get all patients**/
    @GetMapping("/patients")
    public Iterable<PatientModel> getPatients(){
        return patientService.getPatients();
    }

    /**Endpoint to get one patient**/
    @GetMapping("/patient/{id}")
    public PatientModel getPatient(@PathVariable("id") final Long id){
        Optional<PatientModel> patient = patientService.getPatient(id);
        if(patient.isPresent()) return patient.get();
        else return null ;
    }

    /**Endpoint to update patient information**/
    @PutMapping("/patient/{id}")
    public PatientModel updatePatient(@PathVariable("id") final Long id, @RequestBody PatientModel patientModel){
        /**Check if the patient exist in database**/
        Optional<PatientModel> p = patientService.getPatient(id) ;
        if(p.isPresent()){
            patientService.savePatientModel(patientModel);
            return patientModel ;
        }
        else {
            return null ;
        }
    }
}
