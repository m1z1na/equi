package com.example.equi.service;

public class CalcEqui {

   public static Integer calcSum( Integer amount, Integer cost,  Integer markup){
       Integer sum;
       sum = amount * cost + ( amount * cost *  markup / 100 );
       return sum;
   }
}
