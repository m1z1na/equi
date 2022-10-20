package com.example.equi.service;

import java.math.BigInteger;

public class CalcEqui {

    public static BigInteger calcSum(Integer amount, Integer cost, Integer markup) {
        BigInteger sum;
        sum = BigInteger.valueOf(amount * cost + (amount * cost * markup / 100));
        return sum;
    }
}
