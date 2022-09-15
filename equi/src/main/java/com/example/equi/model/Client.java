package com.example.equi.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Client {

    private Integer id;
    private String name;
    private Integer amount;
    private Integer cost;
    private String waers;
    private Integer markup;

    public Client( String name, String waers, Integer amount, Integer cost, Integer markup) {
        this.amount = amount;
        this.waers = waers;
        this.markup = markup;
        this.amount = amount;
        this.cost = cost;
        this.name = name;
    }
}