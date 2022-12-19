package com.example.equi.repositories;

import com.example.equi.model.Btrip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BtripRepository extends JpaRepository<Btrip, Long> {

    List<Btrip> findByFinind(int finind);
}