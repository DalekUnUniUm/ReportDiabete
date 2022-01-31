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

    /**Endpoint for updated patient**/
    public PatientModel updatePatient(final Long id,PatientModel patientModel){
        /**Check if the patient exist in database**/
        Optional<PatientModel> p = getPatient(id) ;
        if(p.isPresent()){
            PatientModel savedPatientMode = patientRepository.save(patientModel);
            return savedPatientMode ;
        }
        else {
            return null ;
        }

    }

    /**Endpoint to get all patients**/
    public Iterable<PatientModel> getPatients(){
        return patientRepository.findAll();
    }

    /**Endpoint to get one patient**/
    public Optional<PatientModel> getPatient(final Long id){
        Optional<PatientModel> patient = patientRepository.findById(id) ;
        return Optional.ofNullable(patient.orElse(null));
    }
}
