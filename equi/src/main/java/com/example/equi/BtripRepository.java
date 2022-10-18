package com.example.equi;

import com.example.equi.model.Btrip;
import com.example.equi.model.Equi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BtripRepository extends CrudRepository<Btrip, Long> {


}