package com.history.history.controller;

import com.history.history.model.HistoryModel;
import com.history.history.service.HistoryService;
import com.history.history.service.HistoryServiceInterface;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HistoryController {

    @Autowired
    private HistoryServiceInterface historyServiceInterface ;

    /**Get list history from one patient**/
    @GetMapping("/historys/{patId}")
    public List<HistoryModel> getHistorys(@PathVariable("patId") String patId){
        return historyServiceInterface.getHistorys(patId);
    }

    /**Get one note by id**/
    @GetMapping("/history/{id}")
    public HistoryModel getHistory(@PathVariable("id") String id){
        Optional<HistoryModel> history = historyServiceInterface.getHistory(id);
        if(history.isPresent()) return history.get();
        else return null ;
    }

    /**Save note patient**/
    @PostMapping("/history/add")
    public void addHistory(@RequestBody HistoryModel historyModel){
        historyServiceInterface.saveHistory(historyModel);
    }

    /**Update note patient**/
    @PutMapping("/history/{id}")
    public HistoryModel updateHistory(@PathVariable String id, @RequestBody HistoryModel historyModel){
        Optional<HistoryModel> h = historyServiceInterface.getHistory(id);
        if(h.isPresent()){
            historyServiceInterface.saveHistory(historyModel);
            return historyModel ;
        }
        else
            return null ;
    }
}
