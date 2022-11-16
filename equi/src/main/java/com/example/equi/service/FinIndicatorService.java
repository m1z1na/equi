package com.example.equi.service;

import com.example.equi.Cache;
import com.example.equi.model.*;
import com.example.equi.repositories.BtripRepository;
import com.example.equi.repositories.EquiRepository;
import com.example.equi.repositories.FinIndRepository;
import com.example.equi.repositories.FotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FinIndicatorService {
    private Integer finID;
    private Btrip btrip;
    private Equi equi;
    private FOT fot;

    @Autowired
    private static EquiRepository equiRepository;
    @Autowired
    private static FinIndRepository finIndRepository;
    @Autowired
    private static BtripRepository btripRepository;
    @Autowired
    private static FotRepository fotRepository;

    public FinIndicatorService(FinIndRepository finIndRepository, EquiRepository equiRepository, FotRepository fotRepository, BtripRepository btripRepository) {
        this.finIndRepository = finIndRepository;
        this.equiRepository = equiRepository;
        this.fotRepository = fotRepository;
        this.btripRepository = btripRepository;
    }


    public static List<Equi> getEqui(Integer fin) {
        return (List<Equi>) CalcFinInd.calcEquiSumAll(equiRepository.findByFinind(fin));
    }

    public static List<Equi> cache(Integer fin)  {
//        Thread.sleep(20000);
        if(Cache.read(fin).isEmpty() == false){
//            List<Equi> equi = new ArrayList<>();
//            equi.add( Cache.read(2));
            return Cache.read(fin);
        }
        else {

            Iterable<Equi> equis = equiRepository.findByFinind(fin);
            for (Equi equi : equis) {
                Cache.create(equi);
            }
//        return (List<Equi>) CalcFinInd.calcEquiSumAll((Iterable<Equi>) Cache.read(2));
            return (List<Equi>) CalcFinInd.calcEquiSumAll(equiRepository.findByFinind(fin));
        }

    }
    public static List<Btrip> getBtrip(Integer fin) {
        return (List<Btrip>) CalcFinInd.calcBtripSumAll(btripRepository.findByFinind(fin));
    }

    public static List<FOT> getFot(Integer fin) {
        return (List<FOT>) CalcFinInd.calcFOTSumAll(fotRepository.findByFinind(fin));
    }

    public static Optional<FinInd> getFin(Integer fin) {
        return finIndRepository.findById(fin);
    }

    public static Iterable<FinInd> getAll() {
        return finIndRepository.findAll();
    }
}
