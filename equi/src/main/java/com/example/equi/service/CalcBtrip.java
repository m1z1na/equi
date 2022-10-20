package com.example.equi.service;

import com.example.equi.model.Btrip;

import java.math.BigInteger;
import java.util.List;

public class CalcBtrip {
    public static BigInteger calcSum(Integer costroad,
                                     Integer costliving,
                                     Integer costallowance,
                                     Integer daysstay,
                                     Integer daystrip,
                                     Integer plannedtrips) {

        BigInteger sum;
        sum = BigInteger.valueOf((costroad + costliving * daysstay + daystrip * costallowance) * plannedtrips);
        return sum;
    }


    public static Iterable<Btrip> calcSumAll(Iterable<Btrip> btrips){
        for (Btrip btrip : btrips) {
            btrip.setSum(CalcBtrip.calcSum(btrip.getCostroad(), btrip.getCostliving(), btrip.getCostallowance(),
                    btrip.getDaysstay(), btrip.getDaystrip(), btrip.getPlannedtrips()));
        }
        return btrips;
    }
}
