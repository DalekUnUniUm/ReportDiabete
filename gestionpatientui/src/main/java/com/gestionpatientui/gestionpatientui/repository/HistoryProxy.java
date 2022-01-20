package com.gestionpatientui.gestionpatientui.repository;

import com.gestionpatientui.gestionpatientui.model.History;
import com.gestionpatientui.gestionpatientui.model.Patient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Component
public class HistoryProxy {

    private String ipHistory = "172.28.0.4" ;
    //private String ipHistory = "localhost" ;

    public List<History> getHistorys(int id){
        String getHistorysUrl = "http://"+ipHistory+":8082/historys/"+id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<History>> response = restTemplate.exchange(
                getHistorysUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<History>>(){}
        );

        return response.getBody();
    }

    public History getHistory(String id){
        String getHistoryUrl = "http://"+ipHistory+":8082/history/"+id ;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<History> response = restTemplate.exchange(
                getHistoryUrl,
                HttpMethod.GET,
                null,
                History.class
        );
        return response.getBody();
    }

    public History addNote(History h){
        String addNoteUrl = "http://"+ipHistory+":8082/history/add" ;

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<History> request = new HttpEntity<History>(h) ;
        ResponseEntity<History> response = restTemplate.exchange(
                addNoteUrl,
                HttpMethod.POST,
                request,
                History.class
        );

        return response.getBody();
    }

    public History updateNote(History h){
        String updateNoteUrl = "Http://"+ipHistory+":8082/history/"+h.getId();

        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<History> request = new HttpEntity<History>(h);
        ResponseEntity<History> response = restTemplate.exchange(
                updateNoteUrl,
                HttpMethod.PUT,
                request,
                History.class
        );

        return response.getBody();
    }
}
