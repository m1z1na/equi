package com.example.equi.service;

import com.example.equi.model.Btrip;
import com.example.equi.model.Equi;
import com.example.equi.model.FOT;
import com.example.equi.model.FinInd;

import java.util.List;
import java.util.Optional;

public interface FinIndicatorServiceApi {
    List<FinInd> getAll();

    //оборудование
    List<Equi> getEqui(Integer fin);

    void addEqui(Equi equi);
    void deleteEqui(Integer id);

    List<Equi> getEquiCache(Integer fin);
    Optional<Equi> getEquiById(Integer id);

    List<Equi> getEquiCacheAll();

    //командировки
    List<Btrip> getBtrip(Integer fin);

    void addBtrip(Btrip btrip);
    Optional<Btrip> getBtripById(Long id);

    void deleteBtrip(Long id);


    //ФОТ
    List<FOT> getFOT(Integer fin);

    Optional<FOT> getFOTById(Integer id);

    void addFOT(FOT fot);

    Optional<FinInd> getFin(Integer fin);



}
