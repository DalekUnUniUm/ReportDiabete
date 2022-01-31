package com.history.history.controller;

import com.history.history.model.HistoryModel;
import com.history.history.service.HistoryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**Get one note by id
     * @return**/
    @GetMapping("/history/{id}")
    public Optional<HistoryModel> getHistory(@PathVariable("id") String id){
        return historyServiceInterface.getHistory(id);
    }

    /**Save note patient**/
    @PostMapping("/history/add")
    public void addHistory(@RequestBody HistoryModel historyModel){
        historyServiceInterface.saveHistory(historyModel);
    }

    /**Update note patient**/
    @PutMapping("/history/{id}")
    public HistoryModel updateHistory(@PathVariable String id, @RequestBody HistoryModel historyModel){
        return historyServiceInterface.updateHistory(id,historyModel);
    }
}
