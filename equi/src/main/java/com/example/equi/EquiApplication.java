package com.example.equi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EquiApplication {

    public EquiApplication() throws Exception {
    }

    public static void main(String[] args) throws Exception {

        SpringApplication.run(EquiApplication.class, args);
        long time = System.currentTimeMillis();
        while (System.currentTimeMillis() - time < 2500000) {
//		while ( 1 = 1 ) {
            Cache.delete();

        }

    }

}

//
//class Cont {
//
//    Integer[] ar = new Integer[10];
//
//
//    private void add(Integer value) {
//        int index = findIndex();
//        if (index >= 0) {
//            ar[index] = value;
//        } else {
//            insertNew(value);
//        }
//
//    }
//
//    private Integer findIndex() {
//
//        for (int i = 0; i <= ar.length; i++) {
//            if (ar[i] == 0) {
//
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    private void insertNew(Integer value) {
//        Integer[] newAr = new Integer[10];
//
//        for (int i = 1; i <= ar.length; i++) {
//            newAr[i - 1] = ar[i];
//        }
//
//        newAr[9] = value;
//        ar = newAr;
//
//    }
//
//}
//
//
//
//
//
//
//
//
//

















