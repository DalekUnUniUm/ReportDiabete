package com.patient.patient.controller;

import com.patient.patient.model.PatientModel;
import com.patient.patient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    /**Endpoint to get one patient
     * @return**/
    @GetMapping("/patient/{id}")
    public Optional<PatientModel> getPatient(@PathVariable("id") final Long id){
        return patientService.getPatient(id);
    }

    /**Endpoint to update patient information**/
    @PutMapping("/patient/{id}")
    public PatientModel updatePatient(@PathVariable("id") final Long id, @RequestBody PatientModel patientModel){
        return patientService.updatePatient(id,patientModel);
    }
}
