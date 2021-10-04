package com.generator.generator.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "history")
public class GeneratorModel {

    @Id
    private String id ;

    @Field(value = "patId")
    private String patId;

    private int triggerTerm ;

    public int getTriggerTerm() {
        return triggerTerm;
    }

    public void setTriggerTerm(int triggerTerm) {
        this.triggerTerm = triggerTerm;
    }
}
