package com.example.equi.repositories;

import com.example.equi.model.Btrip;
import com.example.equi.model.Equi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BtripRepository extends CrudRepository<Btrip, Long> {

    List<Btrip> findByFinind(int finind);
}