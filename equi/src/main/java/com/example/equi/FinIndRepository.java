package com.example.equi;


import com.example.equi.model.FinInd;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinIndRepository extends CrudRepository<FinInd, Integer> {


}
