package com.example.clinique.service;

import com.example.clinique.entity.Clinique;
import com.example.clinique.entity.Medecin;
import com.example.clinique.repository.Cliniquerepository;
import com.example.clinique.repository.MedecinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedecinService {
    @Autowired
    MedecinRepository medecinRepository;
    @Autowired
    Cliniquerepository cliniquerepository;
    public Medecin addmedecintoclinique(Medecin medecin, Long cliniqueid){
        Clinique c=cliniquerepository.findById(cliniqueid).orElse(null);
        List<Medecin> list=new ArrayList<>();
        list.add(medecin);
        if(c.getMedecins()==null){
            c.setMedecins(list);
        }
        else{
            c.getMedecins().add(medecin);
        }
        return medecinRepository.save(medecin);
    }
}
