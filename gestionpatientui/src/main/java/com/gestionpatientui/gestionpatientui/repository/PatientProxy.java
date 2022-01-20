package com.gestionpatientui.gestionpatientui.repository;

import com.gestionpatientui.gestionpatientui.model.Patient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PatientProxy {

    private String ipPatient = "172.28.0.3" ;
    //private String ipPatient = "localhost" ;

    public Iterable<Patient> getPatients(){
        String getPatientsUrl = "http://"+ipPatient+":8080/patients" ;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Patient>> response = restTemplate.exchange(
                getPatientsUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Iterable<Patient>>() {}
        );
        return response.getBody();
    }

    public Patient getPatient(int id){
        String getPatientUrl = "http://"+ipPatient+":8080/patient/"+id ;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Patient> response = restTemplate.exchange(
                getPatientUrl,
                HttpMethod.GET,
                null,
                Patient.class
        );
        return response.getBody();
    }

    public Patient addPatient(Patient p){
        String addPatientUrl = "http://"+ipPatient+":8080/patient/add" ;

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Patient> request = new HttpEntity<Patient>(p) ;
        ResponseEntity<Patient> response = restTemplate.exchange(
                addPatientUrl,
                HttpMethod.POST,
                request,
                Patient.class
        );

        return response.getBody();
    }

    public Patient updatePatient(Patient p){
        String updatePatientUrl = "http://"+ipPatient+":8080/patient/"+p.getId() ;
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Patient> request = new HttpEntity<Patient>(p);
        ResponseEntity<Patient> response = restTemplate.exchange(
                updatePatientUrl,
                HttpMethod.PUT,
                request,
                Patient.class
        );

        return response.getBody();
    }
}
