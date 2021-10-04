package com.history.history.service;

import com.history.history.model.HistoryModel;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface HistoryServiceInterface {

    List<HistoryModel> getHistorys(String patId);

    Optional<HistoryModel> getHistory(String id);

    void saveHistory(HistoryModel historyModel);

}
