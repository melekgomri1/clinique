package com.example.clinique.repository;

import com.example.clinique.entity.Rendevous;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Rendevousrepository extends JpaRepository<Rendevous,Long> {
}
