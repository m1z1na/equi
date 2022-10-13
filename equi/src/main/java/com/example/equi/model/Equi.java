package com.example.equi.model;
//import lombok.Data;
import org.hibernate.annotations.Type;
import javax.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


//@Setter
//@Getter
@Entity
//@Component
@Table(name = "equii")
//@Entity(name = "EQUII")
public class Equi {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer amount;
    private Integer cost;
    private String waers;
    private Integer markup;

    public Equi( String name, String waers, Integer amount, Integer cost, Integer markup) {
        this.amount = amount;
        this.waers = waers;
        this.markup = markup;
        this.amount = amount;
        this.cost = cost;
        this.name = name;
    }

    public Equi() {
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("equi{");
        sb.append("id=").append(id);
        sb.append(", amount='").append(amount).append('\'');
        sb.append(", waers='").append(waers).append('\'');
        sb.append(", cost='").append(cost).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAmount() {
        return amount;
    }

    public Integer getCost() {
        return cost;
    }

    public String getWaers() {
        return waers;
    }

    public Integer getMarkup() {
        return markup;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public void setWaers(String waers) {
        this.waers = waers;
    }

    public void setMarkup(Integer markup) {
        this.markup = markup;
    }
}