package com.gestionpatientui.gestionpatientui.repository;

import com.gestionpatientui.gestionpatientui.model.Generator;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GeneratorProxy {

    public int getTriggerTerm(String patId){
        String getTriggerTermUrl = "http://localhost:8084/generator/"+patId;

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Integer> response = restTemplate.exchange(
                getTriggerTermUrl,
                HttpMethod.GET,
                null,
                Integer.class
        );

        return response.getBody();
    }

}
