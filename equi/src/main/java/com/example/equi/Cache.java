package com.example.equi;

import com.example.equi.model.Equi;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;


import java.util.*;

@PropertySource("classpath:application.properties")
@Data
@Service
public class Cache<K, V> {

    @Value("${size}")
    private int newsize;
    private Object type;

    private List<V> list = (List<V>) new ArrayList<Equi>();

    private final MyLinkedHashMap<K, V> CACHE_MAP = new MyLinkedHashMap<K, V>(newsize);

    public void setNewSize(int newsize) {
        this.newsize = newsize;
    }

    public int showSize() {
        return newsize;
    }


    public List<V> getAll() {
        list.clear();
        for (Map.Entry<K, V> equi :
                CACHE_MAP.entrySet()) {
          list.add( equi.getValue() );
        }

        return list;
    }

    public V getFromCache(K key) {
        return CACHE_MAP.get( key );
    }


    public void add(K key, V value) {
        if( CACHE_MAP.size() == 0) {
            type = value.getClass();
        }
        else if( type == value.getClass()) {
            CACHE_MAP.put(key, value);
        }
    }
}

