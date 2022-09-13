package com.example.equi.model;

public class Client {
    private Integer id;
    private String name;
    private Integer amount;
    private String waers;
    private Integer markup;

    public Client(Integer amount, String waers, Integer markup) {
        this.amount = amount;
        this.waers = waers;
        this.markup = markup;
        this.amount = amount;
        this.name = name;
    }

    public String getWaers() {
        return waers;
    }

    public void setWaers(String waers) {
        this.waers = waers;
    }

    public Integer getMarkup() {
        return markup;
    }

    public void setMarkup(Integer markup) {
        this.markup = markup;
    }


    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}