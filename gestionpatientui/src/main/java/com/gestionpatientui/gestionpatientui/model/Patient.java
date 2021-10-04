package com.gestionpatientui.gestionpatientui.model;

import lombok.Data;
@Data
public class Patient {

    private Integer id ;
    private String firstName ;
    private String lastName ;
    private String dateOfBirth ;
    private String sexe ;

    private String adress ;

    private String phone ;

    public Integer getId() {
        return id;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSexe() {
        return sexe;
    }
}
