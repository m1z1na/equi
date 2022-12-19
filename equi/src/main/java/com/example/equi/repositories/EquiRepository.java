package com.example.equi.repositories;


import com.example.equi.model.Equi;
import com.example.equi.model.FinInd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquiRepository extends JpaRepository<Equi, Integer> {

    List<Equi> findByFinind(int finind) ;
}

