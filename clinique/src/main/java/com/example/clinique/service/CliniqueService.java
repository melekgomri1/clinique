package com.example.clinique.service;


import com.example.clinique.entity.Clinique;
import com.example.clinique.repository.Cliniquerepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CliniqueService {
    @Autowired
    Cliniquerepository cliniquerepository;
    public Clinique addclinique(Clinique clinique){
        return cliniquerepository.save(clinique);
    }
}
