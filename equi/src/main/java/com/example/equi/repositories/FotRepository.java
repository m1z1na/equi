package com.example.equi.repositories;

import com.example.equi.model.Btrip;
import com.example.equi.model.FOT;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FotRepository extends CrudRepository<FOT, Integer> {

    List<FOT> findByFinind(int finind);
}
