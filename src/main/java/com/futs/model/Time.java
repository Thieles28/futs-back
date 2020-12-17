package com.futs.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(schema = "DB_FUTTS", name = "TB_TIME")
public class Time {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigoTime;

    @NotEmpty
    @NotNull
    @Column(name = "NOME")
    private String nome;
    
}
