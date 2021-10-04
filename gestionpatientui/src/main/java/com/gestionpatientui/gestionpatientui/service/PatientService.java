package com.gestionpatientui.gestionpatientui.service;

import com.gestionpatientui.gestionpatientui.model.Patient;
import com.gestionpatientui.gestionpatientui.repository.PatientProxy;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class PatientService {

    @Autowired
    private PatientProxy patientProxy ;

    public Iterable<Patient> getPatients(){
        return patientProxy.getPatients();
    }

    public Patient getPatient(final int id){
        return patientProxy.getPatient(id);
    }

    public Patient addPatient(Patient patient){
        Patient savedPatient ;

        if(patient.getId() == null){
            savedPatient = patientProxy.addPatient(patient);
        }else{
            savedPatient = patientProxy.updatePatient(patient);
        }

        return savedPatient ;
    }
}