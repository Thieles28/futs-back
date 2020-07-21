package com.futs.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(schema = "DB_FUTTS_TESTE", name = "TB_CAMPEONATO")
public class Campeonato {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoCampeonato;
    @NotEmpty
    @NotNull
    @Column(name = "nome")
    private String nome;
}
