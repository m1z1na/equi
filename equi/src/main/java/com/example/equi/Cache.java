package com.example.equi;

import com.example.equi.model.IFinIndChild;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;

@PropertySource("classpath:application.properties")
@Data
@Service
public class Cache<K, V extends IFinIndChild> {

    @Value("${size}")
    private int newsize;


    //только статик файнал капс
//    private final MyLinkedHashMap<K, V> cacheMap = new MyLinkedHashMap<>(newsize);
    private final LinkedHashMap<K, V> cacheMap = new LinkedHashMap<K, V>(newsize);
    private Map<K, Long> timerMap = new LinkedHashMap<>();

    private static final Long TIMEOUT_IN_MILLIS = 10000L;

    public void setNewSize(int newsize) {
        this.newsize = newsize;
    }

    public int showSize() {
        return newsize;
    }


    public void setAll(List<V> list) {

        for (V item : list) {
            addEntry((K) item, item);
        }
    }

    public List<V> getAll() {
//        List<V> list = new ArrayList<>();
//        for (Map.Entry<K, V> equi : cacheMap.entrySet()) {
//            list.add(equi.getValue());
//        }
        //todo вернуть стримом
        checkTimeout();
        return cacheMap.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
//        return list;
    }

    public V get(K key) {

        return cacheMap.get(key);
    }


    public void put(K key, V value) {
        cacheMap.put(key, value);
    }


    public void addEntry(K key, V value) {
        checkTimeout();
        cacheMap.put(key, value);
        timerMap.remove(key);
        timerMap.put(key, System.currentTimeMillis());
    }

    public void getEntry(K key) {
        checkTimeout();
        cacheMap.get(key);
    }

    private void checkTimeout() {
        List<K> removals = new LinkedList<>();
        for (K key : cacheMap.keySet()) {
            if ((System.currentTimeMillis() -
                    timerMap.get(key)) >
                    TIMEOUT_IN_MILLIS) {
                removals.add(key);
            } else {
                break;
            }
        }
        for (K removal : removals) {
            actionAfterTimeout(removal);
        }
    }

    private void actionAfterTimeout(K key) {
        cacheMap.remove(key);
    }


    //В каждом объекте есть finind
    // будем искать по нему
    public List<V> getByFinInd(int finInd) {
        List<V> list = new ArrayList<>();
        for (Map.Entry<K, V> entry : cacheMap.entrySet()) {
            if (finInd == entry.getValue().getFinind())
                list.add(entry.getValue());
        }
        return list;
    }
}





