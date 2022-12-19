package com.example.equi.service;

import junit.framework.TestCase;

public class CalcFinIndTest extends TestCase {

    public void testCalcBtripSum() {

        assertEquals(CalcFinInd.calcBtripSum(1, 1, 1, 1, 1, 10).intValueExact(), 30);
    }

    public void testCalcEquiSum() {
        assertEquals(CalcFinInd.calcEquiSum(0, 0, 0).intValueExact(), 0);
        assertEquals(CalcFinInd.calcEquiSum(5, 2, 10).intValueExact(), 11);
    }


    public void testCalcFOTSum() {
        assertEquals(CalcFinInd.calcFOTSum(5, 2).intValueExact(), 10);
        assertEquals(CalcFinInd.calcFOTSum(0, 30).intValueExact(), 0);
    }


}