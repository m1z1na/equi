package com.example.equi.model;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.repository.query.Param;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.math.BigInteger;


@Setter
@Getter
@Entity
@Table(name = "equii")

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

    private Integer finind;
    private transient BigDecimal sum;
    public Equi( String name, String waers, Integer amount, Integer cost, Integer markup,Integer finind) {
        this.amount = amount;
        this.waers = waers;
        this.markup = markup;
        this.amount = amount;
        this.cost = cost;
        this.name = name;
        this.finind = finind;
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

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }


    public Integer getFinind() {
        return finind;
    }

    public void setFinind(Integer finind) {
        this.finind = finind;
    }
}