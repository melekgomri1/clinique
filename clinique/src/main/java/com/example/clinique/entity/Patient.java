package com.example.clinique.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpatient;
    private String nompatient;
    private int telephone;
    private Date datenaissance;
    @OneToMany(mappedBy = "patient")
    private List<Rendevous> rendevousList;
}
