package com.patient.patient.service;

import com.patient.patient.model.PatientModel;
import com.patient.patient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository ;

    /**Endpoint for add patient**/
    public PatientModel savePatientModel(PatientModel patientModel){
        PatientModel savedPatientMode = patientRepository.save(patientModel);
        return savedPatientMode ;
    }

    /**Endpoint to get all patients**/
    public Iterable<PatientModel> getPatients(){
        return patientRepository.findAll();
    }

    /**Endpoint to get one patient**/
    public Optional<PatientModel> getPatient(final Long id){
        return patientRepository.findById(id);
    }
}
