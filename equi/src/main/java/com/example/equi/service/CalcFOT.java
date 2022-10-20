package com.example.equi.service;

import java.math.BigInteger;

public class CalcFOT {
    public static BigInteger calcSum(Integer hours, Integer rate) {
        BigInteger sum;
        sum = BigInteger.valueOf(hours * rate);
        return sum;
    }
}