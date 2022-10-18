package com.example.equi.service;

public class CalcBtrip {
    public static Integer calcSum(Integer costroad,
                                  Integer costliving,
                                  Integer costallowance,
                                  Integer daysstay,
                                  Integer daystrip,
                                  Integer plannedtrips) {

        Integer sum;
        sum = (costroad + costliving * daysstay + daystrip * costallowance) * plannedtrips;
        return sum;
    }
}
