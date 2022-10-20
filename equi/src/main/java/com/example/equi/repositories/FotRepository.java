package com.example.equi.repositories;

import com.example.equi.model.FOT;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FotRepository extends CrudRepository<FOT, Integer> {


}
