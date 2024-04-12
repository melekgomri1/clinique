package com.example.clinique.Contoller;

import com.example.clinique.entity.*;
import com.example.clinique.service.CliniqueService;
import com.example.clinique.service.MedecinService;
import com.example.clinique.service.Patientservice;
import com.example.clinique.service.Rendevousservice;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CliniqueController {
    @Autowired
    private Rendevousservice rendevousservice;
    @Autowired
    private MedecinService medecinService;
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
    @PostMapping("/addmedecin/{idclinique}")
    public Medecin addpatient(@RequestBody Medecin medecin, @PathVariable Long idclinique){
        return medecinService.addmedecintoclinique(medecin,idclinique);
    }
    @PostMapping("/addrdv/{idp}/{idm}")
    public Rendevous addrendevous(@RequestBody Rendevous rendevous, @PathVariable Long idp,@PathVariable Long idm){
        return rendevousservice.addrdv(rendevous,idp,idm);
    }
    @GetMapping("/getrendevous/{idc}/{sp}")
    private List<Rendevous> getrdv(@PathVariable Long idc, @PathVariable Specialite sp){
        return rendevousservice.getrendevousbyclinisueandsp(idc,sp);
    }
    @GetMapping("/getnbr/{idm}")
    private int getnbr(@PathVariable Long idm){
        return rendevousservice.getnbreRendvous(idm);
    }
    @PutMapping("/update/{idpatient}")
    private void updatepatient(@RequestBody Patient patient,@PathVariable Long idpatient ){
        patientservice.updatepatient(patient,idpatient);
    }
}
