package com.example.equi;

import com.example.equi.model.Equi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {


    private static List<Equi> list = new ArrayList<>();
    private static final Map<Integer, Equi> EQUI_REPOSITORY_MAP = new HashMap<>();

    public static List<Equi> readAll() {
        list.clear();
        for (Map.Entry<Integer, Equi> equi :
                EQUI_REPOSITORY_MAP.entrySet()) {
            list.add(EQUI_REPOSITORY_MAP.get(equi.getValue().getId()));
        }

        return list;
    }

    public static List<Equi> read(int id) {

        list.clear();
        for (Map.Entry<Integer, Equi> equi :
                EQUI_REPOSITORY_MAP.entrySet()) {
            if (equi.getValue().getFinind() == id) {

                list.add(EQUI_REPOSITORY_MAP.get(equi.getValue().getId()));
            }
        }
        return list;

    }
    //add
    public static void create(Equi equi) {
        equi.setTimes(System.currentTimeMillis());
        EQUI_REPOSITORY_MAP.put(equi.getId(), equi);
    }

    public static int test() {

        return EQUI_REPOSITORY_MAP.size();
    }

    public static void delete() throws InterruptedException {

        Thread.sleep(5000);
        if (EQUI_REPOSITORY_MAP.size() > 3) {


            for (Map.Entry<Integer, Equi> equi :
                    EQUI_REPOSITORY_MAP.entrySet()) {
                if (EQUI_REPOSITORY_MAP.size() <= 3) {
                    break;
                } else {
                    EQUI_REPOSITORY_MAP.remove(equi.getValue().getId());
                }
            }

        } else {
            for (Map.Entry<Integer, Equi> equi :
                    EQUI_REPOSITORY_MAP.entrySet()) {
                if (System.currentTimeMillis() - equi.getValue().getTimes() >= 20000) {

                    EQUI_REPOSITORY_MAP.remove(equi.getValue().getId());
                }
            }
        }
    }
}

