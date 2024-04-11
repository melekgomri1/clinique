package com.example.clinique.repository;

import com.example.clinique.entity.Clinique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Cliniquerepository extends JpaRepository<Clinique,Long> {
}
