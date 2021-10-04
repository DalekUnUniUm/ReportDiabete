package com.gestionpatientui.gestionpatientui.model;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class History {

    private String id ;
    private String patId ;
    private String patient ;
    private String notePractitioner ;

    public String getId() {
        return id;
    }

    public String getPatId() {
        return patId;
    }

    public void setPatId(String patId) {
        this.patId = patId;
    }
}
