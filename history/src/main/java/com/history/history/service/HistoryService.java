package com.history.history.service;

import com.history.history.model.HistoryModel;
import com.history.history.repository.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryService implements HistoryServiceInterface {

    @Autowired
    private HistoryRepository historyRepository ;

    @Override
    public List<HistoryModel> getHistorys(String patId){
        return historyRepository.findByPatId(patId);
    }

    @Override
    public Optional<HistoryModel> getHistory(String id){
        Optional<HistoryModel> history = historyRepository.findNotesById(id);
        return history.map(Optional::of).orElse(null);
    }

    @Override
    public void saveHistory(HistoryModel historyModel){
        historyRepository.save(historyModel);
    }

    @Override
    public HistoryModel updateHistory(String id, HistoryModel historyModel){
        Optional<HistoryModel> h = getHistory(id);
        if(h.isPresent()){
            historyRepository.save(historyModel);
            return historyModel ;
        }
        else
            return null ;
    }
}
