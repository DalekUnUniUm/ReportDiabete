package com.generator.generator.repository;

import com.generator.generator.model.GeneratorModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneratorRepository extends MongoRepository<GeneratorModel, Integer> {

    @Query(value = "{$and : [{patId:?0},{$text:{$search:?1}}]}", count = true)
    int getCountTriggerTerm(String patId, String triggerTerm);

}
