package com.patient.patient.repository;

import com.patient.patient.model.PatientModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<PatientModel, Long> {
}
