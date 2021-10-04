package com.patient.patient.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "patients")
public class PatientModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column(name = "first_name")
    private String firstName ;

    @Column(name = "last_name")
    private String lastName ;

    @Column(name ="birthday")
    private String dateOfBirth ;

    private String sexe ;

    private String adress ;

    private String phone ;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSexe() {
        return sexe;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhone() {
        return phone;
    }
}
