package com.example.equi.service;

import com.example.equi.model.*;
import com.example.equi.repositories.BtripRepository;
import com.example.equi.repositories.EquiRepository;
import com.example.equi.repositories.FinIndRepository;
import com.example.equi.repositories.FotRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FinIndicatorService extends FinInd {
    private Integer finID;
    private BtripModel btrip;
    private Equi equi;
    private FOT fot;

    @Autowired
    private EquiRepository equiRepository;
    @Autowired
    private FinIndRepository finIndRepository;
    @Autowired
    private BtripRepository btripRepository;
    @Autowired
    private FotRepository fotRepository;

    public List<Equi> getEqui(){
       return equiRepository.findByFinind(finID);
    }

}
