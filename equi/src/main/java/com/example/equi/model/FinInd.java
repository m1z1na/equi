package com.example.equi.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "fin")

public class FinInd {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String fio;

    public List<Integer> getIdInt() {
        return Collections.singletonList(id);
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

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Override
    public String toString() {
        return "FinInd{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fio='" + fio + '\'' +
                '}';
    }
}