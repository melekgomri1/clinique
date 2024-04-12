package com.example.clinique.service;

import com.example.clinique.entity.Patient;
import com.example.clinique.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Patientservice {
    @Autowired
    PatientRepository patientRepository;
    public Patient addpatient(Patient patient){
        return patientRepository.save(patient);
    }
    public void updatepatient(Patient patient,Long idpatient){
        if (patientRepository.existsById(idpatient)) {
            patient.setIdpatient(idpatient);
            patientRepository.save(patient);
        }
    }
}
