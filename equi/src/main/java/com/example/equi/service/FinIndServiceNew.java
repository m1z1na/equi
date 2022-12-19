package com.example.equi.service;

import com.example.equi.Cache;
import com.example.equi.model.Btrip;
import com.example.equi.model.Equi;
import com.example.equi.model.FOT;
import com.example.equi.model.FinInd;
import com.example.equi.repositories.BtripRepository;
import com.example.equi.repositories.EquiRepository;
import com.example.equi.repositories.FinIndRepository;
import com.example.equi.repositories.FotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FinIndServiceNew implements FinIndicatorServiceApi {

    @Autowired
    private EquiRepository equiRepository;
    @Autowired
    private FinIndRepository finIndRepository;
    @Autowired
    private BtripRepository btripRepository;
    @Autowired
    private FotRepository fotRepository;

    private Cache equiCache;
    private Cache fotCache;
    private Cache btripCache;

    public FinIndServiceNew(EquiRepository equiRepository, FinIndRepository finIndRepository, BtripRepository btripRepository, FotRepository fotRepository) {
        this.equiRepository = equiRepository;
        this.finIndRepository = finIndRepository;
        this.btripRepository = btripRepository;
        this.fotRepository = fotRepository;
        fotCache = new Cache();
        equiCache = new Cache();
        btripCache = new Cache();

    }

    public List<Equi> getEqui(Integer fin) {
        //взять из cache
        List<Equi> list = equiCache.getByFinInd(fin);
        if (list.size() == 0) {
            //если нет то repository и положить в cache
            list = equiRepository.findByFinind(fin);
            equiCache.setAll(list);
        }
        return CalcFinInd.calcEquiSumAll(list);
    }


    public void addEqui(Equi equi) {
        equiRepository.save(equi);
    }


    public void deleteEqui(Integer id) {
        equiRepository.deleteById(id);
    }

    //для теста
    public List<Equi> getEquiCache(Integer fin) {

        return equiCache.getByFinInd(1);
    }


    public Optional<Equi> getEquiById(Integer id) {
       return equiRepository.findById(id);
    }

    public Optional<Btrip> getBtripById(Long id) {
       return btripRepository.findById(id);
    }

    //для теста
    public List<Equi> getEquiCacheAll() {
        return equiCache.getAll();
    }


    public List<Btrip> getBtrip(Integer fin) {
        List<Btrip> list = btripCache.getByFinInd(fin);
        if (list.size() == 0) {
            list = btripRepository.findByFinind(fin);
            btripCache.setAll(list);
        }
        return CalcFinInd.calcBtripSumAll(list);
    }


    public List<FOT> getFOT(Integer fin) {
        List<FOT> list = fotCache.getByFinInd(fin);
        if (list.size() == 0) {
            list = fotRepository.findByFinind(fin);
            fotCache.setAll(list);
        }
        return CalcFinInd.calcFOTSumAll(list);
    }

    public Optional<FinInd> getFin(Integer fin) {
        return finIndRepository.findById(fin);
    }

    public List<FinInd> getAll() {
        return finIndRepository.findAll();
    }

    public void addFOT(FOT fot) {
        fotRepository.save(fot);
    }

    public Optional<FOT> getFOTById(Integer id) {
        return fotRepository.findById(id);
    }

    public void addBtrip(Btrip btrip) {
        btripRepository.save(btrip);
    }

    public void deleteBtrip(Long id) {
        btripRepository.deleteById(id);
    }
}
