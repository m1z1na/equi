package com.example.equi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;


@Setter
@Getter
@Entity
@Table(name = "fot")
public class FOT implements IFinIndChild{
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String workname;
    private String worker;
    private Integer hours;
    private Integer rate;
    private Integer finind;
    private transient BigDecimal sum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkname() {
        return workname;
    }

    public void setWorkname(String workname) {
        this.workname = workname;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
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

    @Override
    public String toString() {
        return "FOT{" +
                "id=" + id +
                ", workname='" + workname + '\'' +
                ", worker='" + worker + '\'' +
                ", hours=" + hours +
                ", rate=" + rate +
                ", finind=" + finind +
                ", sum=" + sum +
                '}';
    }
}