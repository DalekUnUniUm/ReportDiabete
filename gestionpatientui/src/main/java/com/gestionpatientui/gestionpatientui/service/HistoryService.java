package com.gestionpatientui.gestionpatientui.service;

import com.gestionpatientui.gestionpatientui.model.History;
import com.gestionpatientui.gestionpatientui.repository.HistoryProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryService {

    @Autowired
    private HistoryProxy historyProxy ;

    public List<History> getHistorys(final int id){
        return historyProxy.getHistorys(id) ;
    }

    public History getHistory(String id){
        return historyProxy.getHistory(id);
    }

    public History addNote(History history){
        History savedHistory;

        if(history.getId() == null){
            savedHistory = historyProxy.addNote(history);
        }else{
            savedHistory = historyProxy.updateNote(history);
        }

        return savedHistory ;
    }
}
