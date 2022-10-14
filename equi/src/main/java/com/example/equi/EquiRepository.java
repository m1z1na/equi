package com.example.equi;


import com.example.equi.model.Equi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EquiRepository extends CrudRepository<Equi, Integer> {


}
