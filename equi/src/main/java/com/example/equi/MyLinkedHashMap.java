package com.example.equi;

import org.springframework.context.annotation.PropertySource;

import java.util.LinkedHashMap;



@PropertySource("classpath:application.properties")

public class MyLinkedHashMap<String, V> extends LinkedHashMap<String, V> {

    private int maxSize = 1;

    public MyLinkedHashMap(int capacity) {
        super(capacity, 0.75f, true);
        this.maxSize = capacity;
    }

    public V getNew(String key) {
        V v = super.get(key);
        return v;
    }

    public V put(String key, V value) {
        if (value.equals(getNew(key))) {
        }
        else{
            super.put(key, value);
        }
        return value;
    }
}