package com.example.equi.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;


@Setter
@Getter
@Entity
@Table(name = "btrips")
public class Btrip {


    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long Id;
    private Integer costroad;
    private Integer costliving;
    private Integer costallowance;
    private Integer daysstay;
    private Integer daystrip;
    private Integer plannedtrips;
    private Integer finind;
    private transient BigDecimal sum;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getCostroad() {
        return costroad;
    }

    public void setCostroad(Integer costroad) {
        this.costroad = costroad;
    }

    public Integer getCostliving() {
        return costliving;
    }

    public void setCostliving(Integer costliving) {
        this.costliving = costliving;
    }

    public Integer getCostallowance() {
        return costallowance;
    }

    public void setCostallowance(Integer costallowance) {
        this.costallowance = costallowance;
    }

    public Integer getDaysstay() {
        return daysstay;
    }

    public void setDaysstay(Integer daysstay) {
        this.daysstay = daysstay;
    }

    public Integer getDaystrip() {
        return daystrip;
    }

    public void setDaystrip(Integer daystrip) {
        this.daystrip = daystrip;
    }

    public Integer getPlannedtrips() {
        return plannedtrips;
    }

    public void setPlannedtrips(Integer plannedtrips) {
        this.plannedtrips = plannedtrips;
    }

    @Override
    public String toString() {
        return "Btrip{" +
                "Id=" + Id +
                ", costroad=" + costroad +
                ", costliving=" + costliving +
                ", costallowance=" + costallowance +
                ", daysstay=" + daysstay +
                ", daystrip=" + daystrip +
                ", plannedtrips=" + plannedtrips +
                '}';
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
