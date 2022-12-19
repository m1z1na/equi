package com.example.equi.service;

import com.example.equi.model.Btrip;
import com.example.equi.model.Equi;
import com.example.equi.model.FOT;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CalcFinInd {

        public static BigDecimal calcBtripSum(Integer costroad,
                                         Integer costliving,
                                         Integer costallowance,
                                         Integer daysstay,
                                         Integer daystrip,
                                         Integer plannedtrips) {

            BigDecimal sum;
            sum = BigDecimal.valueOf((costroad + costliving * daysstay + daystrip * costallowance) * plannedtrips);
            return sum;
        }



    public static BigDecimal calcEquiSum(Integer amount, Integer cost, Integer markup) {
        BigDecimal sum;
        sum = BigDecimal.valueOf(amount * cost + (amount * cost * markup / 100));
        return sum;
    }


    public static List<Equi> calcEquiSumAll(List<Equi> equis){
        for (Equi equi : equis) {
            equi.setSum(calcEquiSum(equi.getAmount(), equi.getCost(), equi.getMarkup()));
        }
        return equis;
    }


    public static BigDecimal calcFOTSum(Integer hours, Integer rate) {
        BigDecimal sum;
        sum = BigDecimal.valueOf(hours * rate);
        return sum;
    }


    public static List<FOT> calcFOTSumAll(List<FOT> fots){
        for (FOT fot : fots) {
            fot.setSum(calcFOTSum(fot.getHours( ), fot.getRate()));
        }
        return fots;
    }


    public static List<Btrip> calcBtripSumAll(List<Btrip> btrips){
        for (Btrip btrip : btrips) {
            btrip.setSum(calcBtripSum( btrip.getCostroad(),
                    btrip.getCostliving(),
                    btrip.getCostallowance(),
                    btrip.getDaysstay(),
                    btrip.getDaystrip(),
                    btrip.getPlannedtrips() ));
        }
        return btrips;
    }



}