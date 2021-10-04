package com.history.history.repository;

import com.history.history.model.HistoryModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HistoryRepository extends MongoRepository<HistoryModel, Integer> {

    @Query("{patId:?0}")
    List<HistoryModel> findByPatId(String patId) ;

    @Query("{_id:?0}")
    Optional<HistoryModel> findNotesById(String id);
}
