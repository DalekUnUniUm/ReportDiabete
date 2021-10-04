package com.history.history.model;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@Document(collection = "history")
public class HistoryModel {

    @Id
    private String id ;

    @Field(value = "patId")
    private String patId ;

    @Field(value = "patient")
    private String patient ;

    @Field(value = "notePractitioner")
    private String notePractitioner ;

}
