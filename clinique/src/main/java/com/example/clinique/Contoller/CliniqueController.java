package com.example.clinique.Contoller;

import com.example.clinique.entity.Clinique;
import com.example.clinique.entity.Patient;
import com.example.clinique.service.CliniqueService;
import com.example.clinique.service.Patientservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CliniqueController {
    @Autowired
    private CliniqueService cliniqueService;
    @Autowired
    private Patientservice patientservice;
    @PostMapping("/addclinique")
    public Clinique addclinique(@RequestBody Clinique clinique){
        return cliniqueService.addclinique(clinique);
    }
    @PostMapping("/addpatient")
    public Patient addpatient(@RequestBody Patient patient){
        return patientservice.addpatient(patient);
    }
}
