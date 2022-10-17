package com.example.equi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;



@Setter
@Getter
@Entity
@Table(name = "finind")

public class FinInd {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;
    private String name;
    private String fio;


}