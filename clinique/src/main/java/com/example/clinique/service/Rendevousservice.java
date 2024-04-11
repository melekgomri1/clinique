package com.example.clinique.service;

import com.example.clinique.entity.*;
import com.example.clinique.repository.Cliniquerepository;
import com.example.clinique.repository.MedecinRepository;
import com.example.clinique.repository.PatientRepository;
import com.example.clinique.repository.Rendevousrepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class Rendevousservice {
    @Autowired
    Cliniquerepository cliniquerepository;
    @Autowired
    Rendevousrepository rendevousrepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    MedecinRepository medecinRepository;
    public Rendevous addrdv(Rendevous rendevous,Long idmedecin,Long idpatient){
        Medecin m=medecinRepository.findById(idmedecin).orElse(null);
        Patient p=patientRepository.findById(idpatient).orElse(null);
        rendevous.setPatient(p);
        rendevous.setMedecin(m);
        return rendevousrepository.save(rendevous);
    }
    public List<Rendevous> getrendevousbyclinisueandsp(Long idclinique, Specialite specialite){
        Clinique c=cliniquerepository.findById(idclinique).orElse(null);
        List<Rendevous> list=rendevousrepository.findAll();
        List<Rendevous> resultat=new ArrayList<>();
        for(Rendevous r:list){
            Medecin m=r.getMedecin();
            if(r.getMedecin().getCliniques()!=null){
                for(Clinique cc:r.getMedecin().getCliniques()){
                    if(c.equals(cc) && m.getSpecialite().equals(specialite)){
                        resultat.add(r);
                    }
                }
            }
        }
        return resultat;
    }

    public int getnbreRendvous(Long idMedecin){
        int nb=0;
        Medecin m=medecinRepository.findById(idMedecin).orElse(null);
        List<Rendevous> list=rendevousrepository.findAll();
        for(Rendevous r:list){
            nb++;
        }
        return nb;
    }
    @Scheduled(cron = "*/30 * * * *")
    public void retrieveRendevous(){
        List<Rendevous> list=rendevousrepository.findAll();
        for(Rendevous r:list){
            if(r.getDaterendevous().after(new Date())){
                log.info("la liste des rendevous:"+r.getDaterendevous()+"medecein"+r.getMedecin()+r.getMedecin().getNommedecin()+"patient"+r.getPatient().getNompatient());
            }
        }
    }
}

